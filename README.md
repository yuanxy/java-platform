## 该工程不更新了。请移步到结构更合理的新工程 https://github.com/xiangxik/castle-platform 

# Static modular java development platform
Based on servlet3.1 module standardization, use spring MVC, JPA, spring data, querydsl, shiro, fastjson, Beetl, infinispan, redis etc. open source technology, build the modular extension of Java framework, and can choose to use extjs6, easyUI, bootstrap with the public function of the backstage management.

# 静态模块化java开发平台
基于servlet3.1的模块化规范，采用spring, spring mvc, jpa, spring data, querydsl, shiro, fastjson, beetl, infinispan, redis等开源技术，搭建了一套可模块化扩展的java框架，并可选择地使用extjs6、easyui、bootstrap实现了后台管理的公共功能。

# Overview（概览）
![Alt Overview（概览）](http://ken.whenling.com/img/javaplatform/overview.jpg)

## Feature
* based on the latest Java technology
* use Java8 syntax
* Custom modular, custom configuration
* major modular ideas are derived from the web specification of the servlet3.1 integration mechanism
* extensible module, by introducing the jar package to decide whether to use the function
* use javaconfig. no spring configuration file
* use querydsl general query
* contains general background management functions

### 特点
* 基于目前最新的一些java技术
* 采用Java8的语法
* 自定义模块化，自定义配置
* 主要模块化的思想是来自于servlet3.1规范的web集成机制
* 可扩展模块，通过引入jar包来决定是否采用该功能
* 采用spring javaconfig.达到0spring配置文件
* 采用querydsl通用查询
* 包含通用的后台管理功能

## Project Description
* application: platform package, the project can be introduced into the package can contain the main function, depends on all the key module package.
* module-base: constitute the basis of the package package.
* module-domain: platform in the field of data manipulation package, depends on the module-base.
* module-cache: constitute the platform cache function package, depends on the module-domain.
* mongodb module-mongodb: function package.
* netty module-netty: function package.
* redis module-redis: function package.
* web constitute the platform of the module-web: function package, dependent on the module-domain.
* bootstrap constitute the platform of the module-web-bootstrap: package, depends on the module-web.
* easyUI constitute the platform of the module-web-easyui: package, depends on the module-web.
* extjs constitute the platform of the module-web-extjs: package, depends on the module-web.
* module-security: constitute the platform security package, depends on the module-web.
* extension-cms: extend the platform package. Contains the function of CMS. The package is the CMS function.
* extension-mall: expansion platform package, including the mall and the payment and other functions. The introduction of the package that has the function of the mall.
* extension-wechat: expansion platform package. WeChat website contains the display and WeChat related functions.
* plugin-base: plug-in package.
* plugin-payment: payment package.

### 工程用途说明
* application: 平台包，项目引入该包即可包含了主要功能，依赖于全部关键module包。
* module-base: 构成平台的基础包。
* module-domain: 构成平台的领域数据操作包，依赖于module-base。
* module-cache: 构成平台的缓存功能包，依赖于module-domain。
* module-mongodb: mongodb功能包。
* module-netty: netty功能包。
* module-redis: redis功能包。
* module-web: 构成平台的web功能包，依赖于module-domain。
* module-web-bootstrap: 构成平台的bootstrap包，依赖于module-web。
* module-web-easyui: 构成平台的easyui包，依赖于module-web。
* module-web-extjs: 构成平台的extjs包，依赖于module-web。
* module-security: 构成平台的安全包，依赖于module-web。
* extension-cms: 扩展平台包。包含cms的功能。引入该包即拥有cms功能。
* extension-mall: 扩展平台包。包含商城及支付等功能。引入该包即拥有商城功能。
* extension-wechat: 扩展平台包。包含微信网站的展示和微信相关功能。
* plugin-base: 插件基础包。
* plugin-payment: 支付插件包。

## Unfinished project
* module-netty
* module-mongodb

### 未完善工程
* module-netty
* module-mongodb

## Detailed introduction
* http://ken.whenling.com

### 详细介绍
* http://ken.whenling.com

## Update log

##### [2016-04-26]
* add plugins

##### [2016-03-19]
* WeChat pack
* modify extjs processing mode

##### [2016-02-09] V1.0.0.RELEASE
* the first edition released

### 更新日志

#####【2016-04-26】
* 增加插件方式

#####【2016-03-19】
* 增加微信包
* 修改extjs的处理方式

#####【2016-02-09】V1.0.0.RELEASE
* 初版发布
## 集成说明
概述
特点
基于目前最新的一些java技术
采用Java8的语法
自定义模块化，自定义配置
主要模块化的思想是来自于servlet3.1规范的web集成机制
可扩展模块，通过引入jar包来决定是否采用该功能
采用spring javaconfig.达到0spring配置文件
采用querydsl通用查询
包含通用的后台管理功能
工程用途说明
application: 平台包，项目引入该包即可包含了主要功能，依赖于全部关键module包。
module-base: 构成平台的基础包。
module-domain: 构成平台的领域数据操作包，依赖于module-base。
module-cache: 构成平台的缓存功能包，依赖于module-domain。
module-mongodb: mongodb功能包。
module-netty: netty功能包。
module-redis: redis功能包。
module-web: 构成平台的web功能包，依赖于module-domain。
module-web-bootstrap: 构成平台的bootstrap包，依赖于module-web。
module-web-easyui: 构成平台的easyui包，依赖于module-web。
module-web-extjs: 构成平台的extjs包，依赖于module-web。
module-security: 构成平台的安全包，依赖于module-web。
extension-cms: 扩展平台包。包含cms的功能。引入该包即拥有cms功能。
extension-mall: 扩展平台包。包含商城及支付等功能。引入该包即拥有商城功能。
extension-wechat: 扩展平台包。包含微信网站的展示和微信相关功能。
plugin-base: 插件基础包。
plugin-payment: 支付插件包。
开始使用
要使用一个开发平台，首要事情就是把系统部署起来，并能进行最基本的增删改查。该平台的搭建和进行增删改查是十分的简单的事情。下面我们来一步一步地把系统建立起来。

环境搭建
把代码下载下来并导入到eclipse
Alt eclipse

新建maven工程
Alt maven

修改pom.xml文件
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>com.whenling</groupId>
		<artifactId>java-platform</artifactId>
		<version>1.0.0.RELEASE</version>
	</parent>
	<artifactId>whenling-platform</artifactId>
	<packaging>war</packaging>
	<dependencies>
		<dependency>
			<groupId>com.whenling</groupId>
			<artifactId>application</artifactId>
			<version>1.0.0.RELEASE</version>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<configuration>
					<!-- web.xml is not mandatory since JavaEE 5 -->
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
新建初始化器。为了加载自定义的配置文件
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
package com.whenling.example1;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import com.whenling.module.base.config.StaticConfigurationSupplier;
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExampleInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		StaticConfigurationSupplier.prepend("config.properties");
	}
}
创建配置文件config.properties
需要相应地创建此数据库。

1
2
3
jdbc.url=jdbc:mysql://localhost:3306/platform?useUnicode=true&characterEncoding=utf-8
jdbc.username=root
jdbc.password=abcdefg
在webapp下创建WEB-INF文件夹
使用支持servlet3.1的容器启动即可
我使用的是jetty-9.3.3.v20150827
初步使用
输入http://localhost:8080/admin
Alt eclipse

使用初始登陆密码
用户名：admin
密码：asd123
总结
整个项目仅仅需要一个初始化器来读取配置文件，即可运行，且拥有了一个完整的后台管理功能。
如要增加功能，只需在pom.xml添加依赖即可。

模块化原理
各种各样的项目，一些基础总是相同的，如何把基础搭建和巩固起来，使用模块化设计是不错的选择。目前，模块化的产品最规范的是osgi了，不过osgi太过于复杂，而且到现在，各厂商的实现也不能完全的兼容规范。osgi还有个特点是热部署，其实大多数项目，尤其是企业项目，暂停一下服务也不会造成很大的损失。能做到热部署固然是好的，但其增加了项目开发的复杂度，在需求不大的情况下，反而得不偿失。因此，静态模块化的java-platform由此诞生。

java spi
首先，我们需要了解一下java spi。java spi是java6开始，提供的一个jar包之间读取实现类的标准。
主要涉及的类是java.util.ServiceLoader。
只要我们在类路径下的META-INF/services/，创建与接口全名称一样的文件，文件的内容，每一行代表它的一个实现类。
当使用ServiceLoader.load(接口)的时候，java将自动找到所有jar包下面的META-INF/services/接口 文件，加载其描述的实现类。
这样的好处很明显，当一个jar包含有接口的实现类，它的加入，便可以带来的新功能，它的移除，功能也随之移除。功能的添加及移除，不影响任何代码的编写。

servlet3.1
servlet3.0开始，加入了一个不需要web.xml配置的特性，该特性的实现就是通过spi。
在web项目中，只要在META-INF/services/创建文件javax.servlet.ServletContainerInitializer，在项目中实现该接口，并把其添加到文件中，则容器启动时，会加载这些实现类。
我们可以在实现类中增加filter，增加servlet，增加listener，基本上web.xml的功能都能在此体现，而且代码编写比xml强多了。

spring web的支持
spring web根据servlet3.0提供的特性，增加了一个对ServletContainerInitializer的实现。我们从源码中也可以看到：
Alt spring
实现类为org.springframework.web.SpringServletContainerInitializer
查看源码得知，会交给org.springframework.web.WebApplicationInitializer来处理

平台模块化
到此，原理已经很清晰，平台就是通过实现WebApplicationInitializer，实现模块化。

配置
配置是每一个框架最基本的部分，java-platform也不例外。本平台分静态配置和动态配置，静态配置指的是需要重启才会生效的配置，动态配置是能在界面上修改且即时生效的配置。

apache configuration
平台主要使用的配置框架是apache configuration，由它提供了统一的Configuration接口。

静态配置
利用apache configuration工具，得出静态配置类:
com.whenling.module.base.config.StaticConfigurationSupplier
其append和prepend方法可以添加配置文件。
支持的配置文件类型有：xml(层次关系较好)、plist(可以带类型)、properties(常用简单)
加载周期
静态配置应该是在系统启动最初的时候加载，故在org.springframework.web.WebApplicationInitializer的onStartup方法中加载是最好不过的了。
加载顺序
当两个配置相同的时候，平台会使用最先找到的那一项。
与spring配置混合
在ConfigConfiguration中，ConfigurationPropertySourcesPlaceholderConfigurer已做了混合的支持，即可以spring的表达式使用这些配置。
