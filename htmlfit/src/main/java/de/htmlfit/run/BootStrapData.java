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
		mountainClimbers.setName("Mountain Climbers");
		
		Muscle hamstrings = new Muscle();
		hamstrings.setName("hamstrings");
		mr.save(hamstrings);
		
		Collection<Muscle> mountainClimbersMuscles = new ArrayList<Muscle>();
		mountainClimbersMuscles.add(shoulders);
		mountainClimbersMuscles.add(triceps);
		mountainClimbersMuscles.add(abs);
		mountainClimbersMuscles.add(legs);
		mountainClimbersMuscles.add(shoulders);
		mountainClimbersMuscles.add(hamstrings);
		
		mountainClimbers.setMuscles(mountainClimbersMuscles);
		er.save(mountainClimbers);
		
		Exercise jumpingJacks = new Exercise();
		jumpingJacks.setName("Jumping Jacks");
		
		Muscle glutes = new Muscle();
		glutes.setName("Glutes");
		mr.save(glutes);
		
		Muscle hipFlexors = new Muscle();
		hipFlexors.setName("Hip Flexors");
		mr.save(hipFlexors);
		
		Collection<Muscle> jumpingJackMuscles = new ArrayList<Muscle>();
		jumpingJackMuscles.add(hipFlexors);
		jumpingJackMuscles.add(glutes);
		jumpingJackMuscles.add(legs);
		jumpingJackMuscles.add(abs);
		jumpingJackMuscles.add(hamstrings);
		jumpingJackMuscles.add(shoulders);
		jumpingJacks.setMuscles(jumpingJackMuscles);
		er.save(jumpingJacks);
		
		Exercise highKnees = new Exercise();
		highKnees.setName("High Knees");
		
		Muscle calves = new Muscle();
		calves.setName("Calves");
		mr.save(calves);
		
		Collection<Muscle> highKneesMuscles = new ArrayList<Muscle>();
		highKneesMuscles.add(legs);
		highKneesMuscles.add(glutes);
		highKneesMuscles.add(hamstrings);
		highKneesMuscles.add(calves);
		
		highKnees.setMuscles(highKneesMuscles);
		er.save(highKnees);
		
		Exercise squatJumps = new Exercise();
		squatJumps.setName("Squat Jumps");
		
		Muscle quads = new Muscle();
		calves.setName("Quads");
		mr.save(quads);
		
		Muscle biceps = new Muscle();
		calves.setName("Biceps");
		mr.save(biceps);
		
		Collection<Muscle> squatJumpsMuscles = new ArrayList<Muscle>();
		squatJumpsMuscles.add(glutes);
		squatJumpsMuscles.add(hamstrings);
		squatJumpsMuscles.add(calves);
		squatJumpsMuscles.add(quads);
		squatJumpsMuscles.add(biceps);
		squatJumpsMuscles.add(triceps);
		
		squatJumps.setMuscles(squatJumpsMuscles);
		er.save(squatJumps);
		
		//__________________
		Exercise plank = new Exercise();
		plank.setName("Plank");
		
		Muscle trapezius = new Muscle();
		trapezius.setName("Trapezius");
		mr.save(trapezius);
		
		Muscle rhomboid = new Muscle();
		rhomboid.setName("Rhomboid");
		mr.save(rhomboid);
		

		Muscle major = new Muscle();
		major.setName("Major");
		mr.save(major);
		

		Muscle minor = new Muscle();
		minor.setName("Minor");
		mr.save(minor);
		
		Muscle latissimus = new Muscle();
		latissimus.setName("Latissimus");
		mr.save(latissimus);

		Muscle pectorals = new Muscle();
		pectorals.setName("Pectorals");
		mr.save(pectorals);
		
		Muscle serratusAnterior = new Muscle();
		serratusAnterior.setName("Serratus Anterior");
		mr.save(serratusAnterior);
		
		Muscle deltoids = new Muscle();
		deltoids.setName("Deltoids");
		mr.save(deltoids);
		
		Collection<Muscle> plankMuscles = new ArrayList<Muscle>();
		plankMuscles.add(trapezius);
		plankMuscles.add(rhomboid);
		plankMuscles.add(major);
		plankMuscles.add(minor);
		plankMuscles.add(latissimus);
		plankMuscles.add(pectorals);
		plankMuscles.add(biceps);
		plankMuscles.add(serratusAnterior);
		plankMuscles.add(triceps);
		plankMuscles.add(deltoids);
		
		plank.setMuscles(plankMuscles);
		er.save(plank);
		
		Exercise jumps = new Exercise();
		jumps.setName("High Jumps");
		
		Muscle propel = new Muscle();
		propel.setName("Propel");
		mr.save(propel);
		
		Collection<Muscle> jumpsMuscles = new ArrayList<Muscle>();
		jumpsMuscles.add(calves);
		jumpsMuscles.add(hamstrings);
		jumpsMuscles.add(quads);
		jumpsMuscles.add(glutes);
		jumpsMuscles.add(propel);
		jumps.setMuscles(jumpsMuscles);
		er.save(jumps);
		
		Exercise burpeesWJ = new Exercise();
		burpeesWJ.setName("Burpees Without Jumps");
		
		Collection<Muscle> bwjMuscles = new ArrayList<Muscle>();
		bwjMuscles.add(quads);
		bwjMuscles.add(hamstrings);
		bwjMuscles.add(glutes);
		burpeesWJ.setMuscles(bwjMuscles);
		er.save(burpeesWJ);
	
		Exercise splitJumps = new Exercise();
		splitJumps.setName("Split Jumps");
		Collection<Muscle> sjMuscles = new ArrayList<Muscle>();
		sjMuscles.add(quads);
		sjMuscles.add(hamstrings);
		sjMuscles.add(glutes);
		sjMuscles.add(calves);
		splitJumps.setMuscles(sjMuscles);
		er.save(splitJumps);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		
		init();
		
	}
}
