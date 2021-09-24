package jcg.ssowmya.demo.restfulwebservices;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

public class CurrencyResourceApplication {
    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);
        tomcat.setBaseDir("tmp");
        String webAppDirLocation ="src/main/resources/webapp/";
        Context context = tomcat.addWebapp("/restfulws", new File(webAppDirLocation).getAbsolutePath());
        File configFile = new File(webAppDirLocation+"WEB-INF/web.xml");
        context.setConfigFile(configFile.toURI().toURL());
        tomcat.start();
        tomcat.getServer().await();
    }
}
