package de.htmlfit.run;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import de.htmlfit.domain.Exercise;
import de.htmlfit.domain.Muscle;

@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		Exercise burpees = new Exercise();
		burpees.setName("Burpees");
		
		Muscle legs = new Muscle();
		legs.setName("legs");
		
		Muscle shoulders = new Muscle();
		shoulders.setName("shoulders");
		
		Muscle triceps = new Muscle();
		triceps.setName("triceps");
		
		Muscle breast = new Muscle();
		breast.setName("breast");
		
		Muscle back = new Muscle();
		back.setName("back");
				
		Muscle abs = new Muscle();
		abs.setName("abs");
		
		Muscle buttocks = new Muscle();
		buttocks.setName("buttocks");
		
		Collection<Muscle> burpeesMuscles = new ArrayList<Muscle>();
		burpeesMuscles.add(buttocks);
		burpeesMuscles.add(abs);
		burpeesMuscles.add(back);
		burpeesMuscles.add(breast);
		burpeesMuscles.add(triceps);
		burpeesMuscles.add(shoulders);
		burpeesMuscles.add(legs);
		
		burpees.setMuscles(burpeesMuscles);
		
	}
}
