package app.xsis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class XsisApplication {

   public static void main(String[] args) {

      System.setProperty("spring.config.name","web-server");
      SpringApplication.run(XsisApplication.class, args);
   }
}

//for deploy an packaging war

//@SpringBootApplication
//public class XsisApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(XsisApplication.class, args);
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(XsisApplication.class);
//	}
//}
