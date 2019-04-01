package com.sag.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import com.sag.routes.service.ImageService;
import com.sag.routes.service.ServiceI;

@SpringBootApplication(scanBasePackages={"com.sag.routes"})
@PropertySource("classpath:application.properties")
public class LMSApplication extends SpringBootServletInitializer {
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(LMSApplication.class);
	    }
	@Autowired
	ServiceI serviceI;
	@Autowired
	ImageService imageService;
	public static void main(String[] args) {
		SpringApplication.run(LMSApplication.class, args);
	}
	
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}


/*@SpringBootApplication(scanBasePackages = { "com.sag.routes" })
@PropertySource("classpath:application.properties")
public class RoutesApplication {
	@Autowired
	ServiceI serviceI;
	@Autowired
	ImageService imageService;

	public static void main(String[] args) {
		SpringApplication.run(RoutesApplication.class, args);
	}
}*/