package de.htmlfit.run;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import de.htmlfit.domain.Exercise;
import de.htmlfit.domain.Muscle;
import de.htmlfit.repositories.ExerciseRepository;
import de.htmlfit.repositories.MuscleRepository;

@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{
	@Autowired 
	MuscleRepository mr;
	
	@Autowired
	ExerciseRepository er;
	
	public void init() {
		Exercise burpees = new Exercise();
		burpees.setName("Burpees");
		
		Muscle legs = new Muscle();
		legs.setName("legs");
		mr.save(legs);
		
		Muscle shoulders = new Muscle();
		shoulders.setName("shoulders");
		mr.save(shoulders);
		
		Muscle triceps = new Muscle();
		triceps.setName("triceps");
		mr.save(triceps);
		 
		Muscle breast = new Muscle();
		breast.setName("breast");
		mr.save(breast);
		
		Muscle back = new Muscle();
		back.setName("back");
		mr.save(back);
		
		Muscle abs = new Muscle();
		abs.setName("abs");
		mr.save(abs);
		
		Muscle buttocks = new Muscle();
		buttocks.setName("buttocks");
		mr.save(buttocks);
		
		Collection<Muscle> burpeesMuscles = new ArrayList<Muscle>();
		burpeesMuscles.add(buttocks);
		burpeesMuscles.add(abs);
		burpeesMuscles.add(back);
		burpeesMuscles.add(breast);
		burpeesMuscles.add(triceps);
		burpeesMuscles.add(shoulders);
		burpeesMuscles.add(legs);
		
		burpees.setMuscles(burpeesMuscles);
		er.save(burpees);
		
		Exercise mountainClimbers = new Exercise();
		
		Muscle hamstrings = new Muscle();
		hamstrings.setName("hamstrings");
		mr.save(hamstrings);
		
		Collection<Muscle> mountainClimbersMuscles = new ArrayList<Muscle>();
		mountainClimbersMuscles.add(shoulders);
		mountainClimbersMuscles.add(triceps);
		mountainClimbersMuscles.add(abs);
		mountainClimbersMuscles.add(legs);
		mountainClimbersMuscles.add(shoulders);
		
		mountainClimbers.setMuscles(mountainClimbersMuscles);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		
		init();
		
	}
}
