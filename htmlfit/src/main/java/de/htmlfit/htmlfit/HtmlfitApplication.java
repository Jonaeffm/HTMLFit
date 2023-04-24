package de.htmlfit.htmlfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"de.htmlfit.run"})
@SpringBootApplication
public class HtmlfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmlfitApplication.class, args);
	}

}
