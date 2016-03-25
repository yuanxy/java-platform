package com.whenling.extension.mdm.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;

import com.google.common.io.Files;
import com.whenling.extension.mdm.support.openssl.OpenSSLExecutor;
import com.whenling.extension.mdm.support.payload.config.ConfigPayload;
import com.whenling.extension.mdm.support.payload.config.ConfigurationProfileConfig;
import com.whenling.extension.mdm.support.payload.config.MDMConfig;
import com.whenling.extension.mdm.support.payload.config.Pkcs12CertificateConfig;
import com.whenling.extension.mdm.support.payload.config.Pkcs1CertificateConfig;
import com.whenling.extension.mdm.support.plist.PayloadStream;
import com.whenling.module.web.controller.BaseController;

@Controller
@RequestMapping("/mobileconfig")
public class MobileConfigController extends BaseController {

	@Autowired
	private PayloadStream payloadStream;

	@Autowired
	private OpenSSLExecutor executor;

	@Autowired
	private ServletContext servletContext;

	@Value("${mdm.checkInURL?:https://www.whenling.com:8443/checkin}")
	private String checkInURL;

	@Value("${mdm.serverURL?:https://www.whenling.com:8443/server}")
	private String serverURL;

	@Value("${mdm.clientP12Path?:/WEB-INF/ssl/client.p12}")
	private String clientP12Path;

	@Value("${mdm.serverCertPath?:/WEB-INF/ssl/www.whenling.com.crt}")
	private String serverCertPath;

	@Value("${mdm.serverKeyNoPassPath?:/WEB-INF/ssl/www.whenling.com.nopass.key}")
	private String serverKeyNoPassPath;

	@Value("${mdm.rootBundlePath?:/WEB-INF/ssl/root_bundle.crt}")
	private String rootBundlePath;

	private static AtomicLong unique_num = new AtomicLong(0l);

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void get(HttpServletResponse response) {

		Resource customerCertificate = new ClassPathResource("/cert/customer_certificate.pem");
		ConfigurationProfileConfig configurationProfileConfig = new ConfigurationProfileConfig();
		try {
			X509Certificate ca = (X509Certificate) CertificateFactory.getInstance("X.509")
					.generateCertificate(customerCertificate.getInputStream());
			String principal = ca.getSubjectX500Principal().toString();
			String payloadCertificateFileName = StringUtils.substringBetween(principal, "CN=", ",") + ".cer";
			String topic = StringUtils.substringAfter(principal, "UID=");

			Pkcs1CertificateConfig pkcs1CertificateConfig = new Pkcs1CertificateConfig(payloadCertificateFileName,
					Base64.encodeBase64String(ca.getEncoded()));

			String identityCertificateUUID = UUID.randomUUID().toString();
			MDMConfig mdmConfig = new MDMConfig(identityCertificateUUID, serverURL, topic);
			mdmConfig.setPayloadDisplayName("MDM配置");
			mdmConfig.setSignMessage(false);
			mdmConfig.setCheckInURL(checkInURL);
			mdmConfig.setCheckOutWhenRemoved(true);

			Resource clientCertificate = new ServletContextResource(servletContext, clientP12Path);
			Pkcs12CertificateConfig pkcs12CertificateConfig = new Pkcs12CertificateConfig("client.p12",
					Base64.encodeBase64String(IOUtils.toByteArray(clientCertificate.getInputStream())), "asd123");
			pkcs12CertificateConfig.setPayloadUUID(identityCertificateUUID);
			pkcs12CertificateConfig.setPayloadDisplayName("客户端证书");

			configurationProfileConfig.setPayloadContent(
					new ConfigPayload[] { pkcs1CertificateConfig, mdmConfig, pkcs12CertificateConfig });
			configurationProfileConfig.setPayloadIdentifier("com.whenling.mdm");
			configurationProfileConfig.setPayloadDisplayName("移动城堡设备管理配置文件");
			configurationProfileConfig.setPayloadDescription("由广州当凌信息科技有限公司开发和管理的设备管理配置文件");

			String xmlConfig = payloadStream.toXML(configurationProfileConfig);

			response.setContentType("application/x-apple-aspen-config");

			byte[] result = signature(IOUtils.toInputStream(xmlConfig));
			IOUtils.write(result, response.getOutputStream());
		} catch (CertificateException | IOException e) {
			throw new RuntimeException(e);
		}

	}

	private byte[] signature(InputStream in) throws IOException {
		long uniqueNum = unique_num.decrementAndGet();

		String noSignedFilename = "nosign-" + uniqueNum;
		File noSigned = new File(executor.getBaseDir(), noSignedFilename);
		if (noSigned.exists()) {
			noSigned.delete();
		}

		String signedFilename = "sign-" + uniqueNum;
		File signed = new File(executor.getBaseDir(), signedFilename);
		if (signed.exists()) {
			signed.delete();
		}

		Files.write(IOUtils.toByteArray(in), noSigned);

		Resource serverCert = new ServletContextResource(servletContext, serverCertPath);
		Resource serverKeyNoPass = new ServletContextResource(servletContext, serverKeyNoPassPath);
		Resource rootBundle = new ServletContextResource(servletContext, rootBundlePath);

		executor.exec(
				String.format("smime -sign -in %s -out %s -signer %s -inkey %s -certfile %s -outform der -nodetach",
						noSignedFilename, signedFilename, serverCert.getFile().getAbsolutePath(),
						serverKeyNoPass.getFile().getAbsolutePath(), rootBundle.getFile().getAbsolutePath()));

		byte[] result = IOUtils.toByteArray(new FileInputStream(signed));

		noSigned.delete();
		signed.delete();

		return result;
	}

}
