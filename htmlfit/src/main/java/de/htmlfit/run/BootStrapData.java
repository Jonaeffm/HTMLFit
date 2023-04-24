package de.htmlfit.run;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
	}
}
