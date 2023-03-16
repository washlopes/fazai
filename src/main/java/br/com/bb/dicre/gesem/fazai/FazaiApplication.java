package br.com.bb.dicre.gesem.fazai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FazaiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FazaiApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FazaiApplication.class);
	}

}
