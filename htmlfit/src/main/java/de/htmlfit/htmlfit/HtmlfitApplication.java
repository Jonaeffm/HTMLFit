package de.htmlfit.htmlfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("de.htmlfit.repositories") 
@EntityScan("de.htmlfit.domain")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"de.htmlfit.run","de.htmlfit.services","de.htmlfit.htmlfit"})
public class HtmlfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmlfitApplication.class, args);
	}

}
