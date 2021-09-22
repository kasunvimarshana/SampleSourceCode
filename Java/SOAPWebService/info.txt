//https://www.codejava.net/java-ee/web-services/how-to-code-and-deploy-java-xml-web-services-jax-ws-on-tomcat
-Create Java Dynamic Web Project
-Specify JAX-WS Runtime Dependency
-Create a Java XML Web Service
-Configure Web Service Endpoint
-Configure JAX-WS Listner Servlet

__________________________________________________

***Create Dynamic Web Project

	.-Project Name
	.-Dynamic Web Module Version = 3.0
	.-Configuration = Default
	.-Next -> Next -> Generate web.xml Deployment Descriptor (check) -> finish
	.-Right Click On Project -> Configure -> Convert To Maven Project
	
__________________________________________________

***Edit pom.xml

	<!-- https://mvnrepository.com/artifact/com.sun.xml.ws/jaxws-rt -->
	<dependency>
    	<groupId>com.sun.xml.ws</groupId>
    	<artifactId>jaxws-rt</artifactId>
    	<version>2.3.2</version>
    	<type>pom</type>
	</dependency>
	
__________________________________________________

***Change Java Version to JDK 8

	.-Project -> Java Resources -> Libraries -> (Right Click On) JRE System Library[JavaSE-] -> Properties -> Alternate JRE (select) -> (Installed JREs -> Add -> Standard VM -> JRE home -> jdk 1.8.0_301)
	.-Project -> Java Resources -> Libraries -> (Right Click On) JRE System Library[JavaSE-] -> Properties -> Alternate JRE (select) -> Select JDK 8 -> Apply and Close
	
__________________________________________________
	
***Enable Annotation

	.-Window -> Preferences -> Java -> Editor -> Content Assist -> Advanced ->
		:Chain Template Proposals (select)
		:Java Non - Type Proposals (select)
		:Java Proposals (select)
		:Java Type Proposals (select)
	->Apply and Close
	
__________________________________________________
	
***Configure Web Service Endpoint

	.-WebContent -> WEB-INF -> Create XML (sun-javax.ws.xml)
	
	<?xml version="1.0" encoding="UTF-8"?>
	<endpoints xmlns="http://java.sun.com/xml/ns/jax-ws/ri/runtime" version="2.0">
		<endpoint
			name="HelloWebService"
			implementation="com.kasun.Hello"
			url-pattern="/ws/hello"
		/>
	</endpoints>
	
__________________________________________________

***Configure JAX-WS Listner and Servlet

	<listener>
		<listener-class>
			com.sun.xml.ws.transport.http.servlet.WSServletContextListener
		</listener-class>
	</listener>

	<servlet>
		<servlet-name>JAXWSServlet</servlet-name>
		<servlet-class>com.sun.xml.ws.transport.http.servlet.WSServlet</servlet-class>
	</servlet>

	<servlet-mapping>
		<servlet-name>JAXWSServlet</servlet-name>
		<url-pattern>/ws/*</url-pattern>
	</servlet-mapping>
	

__________________________________________________
	
***Import WSDL
wsimport -keep -p net.codejava.test http://localhost:8080/SoapTest/ws/hello?wsdl

__________________________________________________

***Fix Eclipse Incompetible JVM Error

	.-Goto Eclipse Installed Folder -> edit (eclipse.ini) -> Add JDK Path (-vm C:\Program Files\Java\jdk-16.0.1\bin)
	/*
		-startup
		plugins/org.eclipse.equinox.launcher_1.6.300.v20210813-1054.jar
		--launcher.library
		C:\Users\kasun\.p2\pool\plugins\org.eclipse.equinox.launcher.win32.win32.x86_64_1.2.300.v20210828-0802
		-product
		org.eclipse.epp.package.jee.product
		-showsplash
		C:\Users\kasun\.p2\pool\plugins\org.eclipse.epp.package.common_4.21.0.20210910-1200
		--launcher.defaultAction
		openFile
		--launcher.appendVmargs
		-vm
		C:\Program Files\Java\jdk-16.0.1\bin
		-vmargs
		-Dosgi.requiredJavaVersion=11
		-Dosgi.instance.area.default=@user.home/eclipse-workspace
		-Dsun.java.command=Eclipse
		-XX:+UseG1GC
		-XX:+UseStringDeduplication
		--add-modules=ALL-SYSTEM
		-Dosgi.requiredJavaVersion=11
		-Dosgi.dataAreaRequiresExplicitInit=true
		-Dorg.eclipse.swt.graphics.Resource.reportNonDisposed=true
		-Xms256m
		-Xmx2048m
		--add-modules=ALL-SYSTEM
		-Declipse.p2.max.threads=10
		-Doomph.update.url=http://download.eclipse.org/oomph/updates/milestone/latest
		-Doomph.redirection.index.redirection=index:/->http://git.eclipse.org/c/oomph/org.eclipse.oomph.git/plain/setups/
	*/