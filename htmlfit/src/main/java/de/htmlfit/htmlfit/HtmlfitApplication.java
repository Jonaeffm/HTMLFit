package de.htmlfit.htmlfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"de.htmlfit.run"})
@EnableJpaRepositories("de.htmlfit.repositories") 
@EntityScan("de.htmlfit.domain")
@SpringBootApplication
public class HtmlfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmlfitApplication.class, args);
	}

}
