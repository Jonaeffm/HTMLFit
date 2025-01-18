package de.htmlfit.run;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import de.htmlfit.domain.Exercise;
import de.htmlfit.domain.ExerciseBuild;
import de.htmlfit.domain.Muscle;
import de.htmlfit.domain.TrainingEquipment;
import de.htmlfit.repositories.ExerciseBuildRepository;
import de.htmlfit.repositories.ExerciseRepository;
import de.htmlfit.repositories.MuscleRepository;
import de.htmlfit.repositories.TrainingEquipmentRepository;
import de.htmlfit.services.ExerciseService;
import de.htmlfit.services.MuscleService;

@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{
	@Autowired 
	MuscleService ms;
	
	@Autowired
	ExerciseService es;
	
	@Autowired
	ExerciseBuildRepository ebr;
	
	@Autowired
	TrainingEquipmentRepository ter;
	
	public void init() {
		
		//-------------------training equipment---------------
		
		TrainingEquipment dumbbell = new TrainingEquipment();
		dumbbell.setName("Dumbbell");
		ter.save(dumbbell);
		
		TrainingEquipment pullupbar = new TrainingEquipment();
		pullupbar.setName("Pull-Up Bar");
		ter.save(pullupbar);
		
		TrainingEquipment trainingBench = new TrainingEquipment();
		trainingBench.setName("Training Bench");
		ter.save(trainingBench);
		
		//-------------------muscles--------------------------
		
		Muscle gastrocnemius = new Muscle();
		gastrocnemius.setName("gastrocnemius");
		ms.save(gastrocnemius);
		
		Muscle legs = new Muscle();
		legs.setName("quadriceps femoris");
		ms.save(legs);
		
		/*Muscle shoulders = new Muscle();
		shoulders.setName("deltoideus");
		mr.save(shoulders);*/
		
		Muscle triceps = new Muscle();
		triceps.setName("triceps");
		ms.save(triceps);
		 
		Muscle breast = new Muscle();
		breast.setName("pectoralis major");
		ms.save(breast);
		
		Muscle back = new Muscle();
		back.setName("back");
		ms.save(back);
		
		Muscle abs = new Muscle();
		abs.setName("rectus abdominis");
		ms.save(abs);
		
		Muscle buttocks = new Muscle();
		buttocks.setName("gluteus maximus");
		ms.save(buttocks);
		
		Muscle hamstrings = new Muscle();
		hamstrings.setName("hamstrings");
		ms.save(hamstrings);
		
		Muscle glutes = new Muscle();
		glutes.setName("Glutes");
		ms.save(glutes);
		
		Muscle hipFlexors = new Muscle();
		hipFlexors.setName("Hip Flexors");
		ms.save(hipFlexors);
		
		Muscle calves = new Muscle();
		calves.setName("Calves");
		ms.save(calves);
		
		Muscle quads = new Muscle();
		quads.setName("Quads");
		ms.save(quads);
		
		Muscle biceps = new Muscle();
		biceps.setName("Biceps");
		ms.save(biceps);
		
		Muscle propel = new Muscle();
		propel.setName("Propel");
		ms.save(propel);
		
		Muscle trapezius = new Muscle();
		trapezius.setName("Trapezius");
		ms.save(trapezius);
		
		Muscle rhomboid = new Muscle();
		rhomboid.setName("Rhomboid");
		ms.save(rhomboid);
		

		Muscle major = new Muscle();
		major.setName("Major");
		ms.save(major);
		

		Muscle minor = new Muscle();
		minor.setName("Minor");
		ms.save(minor);
		
		Muscle latissimus = new Muscle();
		latissimus.setName("Latissimus");
		ms.save(latissimus);

		Muscle pectorals = new Muscle();
		pectorals.setName("Pectorals");
		ms.save(pectorals);
		
		Muscle serratusAnterior = new Muscle();
		serratusAnterior.setName("Serratus Anterior");
		ms.save(serratusAnterior);
		
		Muscle deltoids = new Muscle();
		deltoids.setName("Deltoids");
		ms.save(deltoids);
		
		Muscle moa = new Muscle();
		moa.setName("Musculus Obliquus abdominis");
		ms.save(moa);
		
		Muscle teresMajor = new Muscle();
		teresMajor.setName("Teres Major");
		ms.save(teresMajor);
		
		Muscle teresMinor = new Muscle();
		teresMinor.setName("Teres Minor");
		ms.save(teresMinor);
		
		Muscle brachialis = new Muscle();
		brachialis.setName("Brachialis");
		ms.save(brachialis);
		
		Muscle hipAdductor = new Muscle();
		hipAdductor.setName("Hip Adductor");
		ms.save(hipAdductor);
		//---------------------------Burpees--------------------------------
		Exercise burpees = new Exercise();
		burpees.setName("Burpees");
		
		Collection<Muscle> burpeesMuscles = new ArrayList<Muscle>();
		burpeesMuscles.add(buttocks);
		burpeesMuscles.add(abs);
		burpeesMuscles.add(back);
		burpeesMuscles.add(breast);
		burpeesMuscles.add(triceps);
		burpeesMuscles.add(deltoids);
		burpeesMuscles.add(legs);
		
		burpees.setMuscles(burpeesMuscles);
		es.save(burpees);
		
		//-----------------------Mountain Climbers--------------------------------
		Exercise mountainClimbers = new Exercise();
		mountainClimbers.setName("Mountain Climbers");
		
		Collection<Muscle> mountainClimbersMuscles = new ArrayList<Muscle>();
		mountainClimbersMuscles.add(deltoids);
		mountainClimbersMuscles.add(triceps);
		mountainClimbersMuscles.add(abs);
		mountainClimbersMuscles.add(legs);
		mountainClimbersMuscles.add(hamstrings);
		
		mountainClimbers.setMuscles(mountainClimbersMuscles);
		es.save(mountainClimbers);
		
		//-----------------------Jumping Jack--------------------------------
		Exercise jumpingJacks = new Exercise();
		jumpingJacks.setName("Jumping Jacks");
		
		Collection<Muscle> jumpingJackMuscles = new ArrayList<Muscle>();
		jumpingJackMuscles.add(hipFlexors);
		jumpingJackMuscles.add(glutes);
		jumpingJackMuscles.add(legs);
		jumpingJackMuscles.add(abs);
		jumpingJackMuscles.add(hamstrings);
		jumpingJackMuscles.add(deltoids);
		jumpingJacks.setMuscles(jumpingJackMuscles);
		es.save(jumpingJacks);
		
		//-----------------------High Knees--------------------------------
		Exercise highKnees = new Exercise();
		highKnees.setName("High Knees");
		
		Collection<Muscle> highKneesMuscles = new ArrayList<Muscle>();
		highKneesMuscles.add(legs);
		highKneesMuscles.add(glutes);
		highKneesMuscles.add(hamstrings);
		highKneesMuscles.add(calves);
		
		highKnees.setMuscles(highKneesMuscles);
		es.save(highKnees);
		
		//-----------------------Squat Jumps--------------------------------
		Exercise squatJumps = new Exercise();
		squatJumps.setName("Squat Jumps");
		
		Collection<Muscle> squatJumpsMuscles = new ArrayList<Muscle>();
		squatJumpsMuscles.add(glutes);
		squatJumpsMuscles.add(hamstrings);
		squatJumpsMuscles.add(calves);
		squatJumpsMuscles.add(quads);
		squatJumpsMuscles.add(biceps);
		squatJumpsMuscles.add(triceps);
		
		squatJumps.setMuscles(squatJumpsMuscles);
		es.save(squatJumps);
		
		//-----------------------Plank--------------------------------
		Exercise plank = new Exercise();
		plank.setName("Plank");
		
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
		es.save(plank);
		
		//-----------------------Jumps--------------------------------
		Exercise jumps = new Exercise();
		jumps.setName("High Jumps");
		
		Collection<Muscle> jumpsMuscles = new ArrayList<Muscle>();
		jumpsMuscles.add(calves);
		jumpsMuscles.add(hamstrings);
		jumpsMuscles.add(quads);
		jumpsMuscles.add(glutes);
		jumpsMuscles.add(propel);
		jumps.setMuscles(jumpsMuscles);
		es.save(jumps);
		
		//-----------------------Burpees Without Jumps--------------------------------
		Exercise burpeesWJ = new Exercise();
		burpeesWJ.setName("Burpees Without Jumps");
		
		Collection<Muscle> bwjMuscles = new ArrayList<Muscle>();
		bwjMuscles.add(quads);
		bwjMuscles.add(hamstrings);
		bwjMuscles.add(glutes);
		burpeesWJ.setMuscles(bwjMuscles);
		es.save(burpeesWJ);
	
		//-----------------------Split Jumps--------------------------------
		Exercise splitJumps = new Exercise();
		splitJumps.setName("Split Jumps");
		Collection<Muscle> sjMuscles = new ArrayList<Muscle>();
		sjMuscles.add(quads);
		sjMuscles.add(hamstrings);
		sjMuscles.add(glutes);
		sjMuscles.add(calves);
		splitJumps.setMuscles(sjMuscles);
		es.save(splitJumps);
		
		//-----------------------Pushup--------------------------------
		Exercise pushup = new Exercise();
		pushup.setName("Pushup");
		
		Collection<Muscle> pMuscles = new ArrayList<Muscle>();
		pMuscles.add(triceps);
		pMuscles.add(pectorals);
		pMuscles.add(deltoids);
		pMuscles.add(back);
		
		pushup.setMuscles(pMuscles);
		es.save(pushup);
		
		//------------------------curls--------------------------------
		ExerciseBuild curls = new ExerciseBuild();
		curls.setName("Curls");
		
		Collection<TrainingEquipment> curlEquipment = new ArrayList<TrainingEquipment>();
		curlEquipment.add(dumbbell);
		
		Collection<Muscle> curlsMuscles = new ArrayList<Muscle>();
		curlsMuscles.add(biceps);
		
		curls.setMuscles(curlsMuscles);
		curls.setTrainingEquipment(curlEquipment);
		ebr.save(curls);
		
		//------------------------concentration curls--------------------------------
		ExerciseBuild ccurls = new ExerciseBuild();
		ccurls.setName("Concentration Curls");
		
		Collection<TrainingEquipment> ccurlEquipment = new ArrayList<TrainingEquipment>();
		ccurlEquipment.add(dumbbell);
				
		Collection<Muscle> ccurlsMuscles = new ArrayList<Muscle>();
		ccurlsMuscles.add(biceps);
				
		ccurls.setTrainingEquipment(ccurlEquipment);
		ccurls.setMuscles(ccurlsMuscles);
		ebr.save(ccurls);
		
		//-----------------------pullup-----------------------------------------
		ExerciseBuild pullup = new ExerciseBuild();
		pullup.setName("Pull Up");
		
		Collection<TrainingEquipment> pullUpEquipment = new ArrayList<TrainingEquipment>();
		pullUpEquipment.add(pullupbar);
		
		Collection<Muscle> pullUpMuscles = new ArrayList<Muscle>();
		pullUpMuscles.add(biceps);
		pullUpMuscles.add(deltoids);
		pullUpMuscles.add(pectorals);
		pullUpMuscles.add(triceps);
		pullUpMuscles.add(abs);
		pullUpMuscles.add(moa);
		pullUpMuscles.add(teresMinor);
		pullUpMuscles.add(teresMajor);
		
		pullup.setMuscles(pullUpMuscles);
		pullup.setTrainingEquipment(pullUpEquipment);
		ebr.save(pullup);
		
		//-----------------------one armed rowing---------------------------
		ExerciseBuild oar = new ExerciseBuild();
		oar.setName("One Armed Rowing");
		
		Collection<TrainingEquipment> oarEquipment = new ArrayList<TrainingEquipment>();
		oarEquipment.add(dumbbell);
		oarEquipment.add(trainingBench);
		
		Collection<Muscle> oarMuscles = new ArrayList<Muscle>();
		oarMuscles.add(trapezius);
		oarMuscles.add(teresMinor);
		oarMuscles.add(latissimus);
		oarMuscles.add(rhomboid);
		oarMuscles.add(teresMinor);
		
		
		oar.setMuscles(oarMuscles);
		oar.setTrainingEquipment(oarEquipment);
		ebr.save(oar);
		
		//-----------------------dumbbell upright row---------------------------
		ExerciseBuild dur = new ExerciseBuild();
		dur.setName("Dumbbell Upright Row");
				
		Collection<TrainingEquipment> durEquipment = new ArrayList<TrainingEquipment>();
		durEquipment.add(dumbbell);
				
		Collection<Muscle> durMuscles = new ArrayList<Muscle>();
		durMuscles.add(trapezius);
		durMuscles.add(deltoids);
		durMuscles.add(biceps);
		durMuscles.add(brachialis);
		durMuscles.add(serratusAnterior);
				
				
		dur.setMuscles(durMuscles);
		dur.setTrainingEquipment(durEquipment);
		ebr.save(dur);
				
		//-----------------------close grip pullup-----------------------------------------
		ExerciseBuild cgpullup = new ExerciseBuild();
		cgpullup.setName("Close Grip Pull Up");
				
		Collection<TrainingEquipment> cgpullUpEquipment = new ArrayList<TrainingEquipment>();
		cgpullUpEquipment.add(pullupbar);
				
		Collection<Muscle> cgpullUpMuscles = new ArrayList<Muscle>();
		cgpullUpMuscles.add(latissimus);
		cgpullUpMuscles.add(biceps);
		cgpullUpMuscles.add(pectorals);
				
		cgpullup.setMuscles(cgpullUpMuscles);
		cgpullup.setTrainingEquipment(cgpullUpEquipment);
		ebr.save(cgpullup);
		
		//-----------------------push-ups-----------------------------------------
		ExerciseBuild pushupBuild = new ExerciseBuild();
		pushupBuild.setName("Push-Ups");
						
		Collection<TrainingEquipment> pushUpEquipment = new ArrayList<TrainingEquipment>();
		pushUpEquipment.add(trainingBench);
						
		Collection<Muscle> pushUpMuscles = new ArrayList<Muscle>();
		pushUpMuscles.add(triceps);
		pushUpMuscles.add(deltoids);
		pushUpMuscles.add(abs);
		pushUpMuscles.add(breast);
		pushUpMuscles.add(serratusAnterior);
		pushUpMuscles.add(legs);
		pushUpMuscles.add(buttocks);
				
						
		pushupBuild.setMuscles(pushUpMuscles);
		pushupBuild.setTrainingEquipment(pushUpEquipment);
		ebr.save(pushupBuild);
		
		//-----------------------diamond push-ups-----------------------------------------
		ExerciseBuild dPushupBuild = new ExerciseBuild();
		dPushupBuild.setName("Diamond Push-Ups");
								
		Collection<TrainingEquipment> dPushUpEquipment = new ArrayList<TrainingEquipment>();
		dPushUpEquipment.add(trainingBench);
								
		Collection<Muscle> dPushUpMuscles = new ArrayList<Muscle>();
		dPushUpMuscles.add(triceps);
		dPushUpMuscles.add(deltoids);
		dPushUpMuscles.add(abs);
		dPushUpMuscles.add(breast);
		dPushUpMuscles.add(serratusAnterior);
								
		dPushupBuild.setMuscles(dPushUpMuscles);
		dPushupBuild.setTrainingEquipment(dPushUpEquipment);
		ebr.save(dPushupBuild);
		
		//-----------------------standing shoulder press-----------------------------------------
		ExerciseBuild ssp = new ExerciseBuild();
		ssp.setName("Standing Shoulder Press");
								
		Collection<TrainingEquipment> sspEquipment = new ArrayList<TrainingEquipment>();
		sspEquipment.add(dumbbell);
								
		Collection<Muscle> sspMuscles = new ArrayList<Muscle>();
		sspMuscles.add(trapezius);
		sspMuscles.add(deltoids);
		sspMuscles.add(triceps);
								
		ssp.setMuscles(sspMuscles);
		ssp.setTrainingEquipment(sspEquipment);
		ebr.save(ssp);
		
		//-----------------------lateral raise-----------------------------------------
		ExerciseBuild lateralRaise = new ExerciseBuild();
		lateralRaise.setName("Lateral Raise");
										
		Collection<TrainingEquipment> lrEquipment = new ArrayList<TrainingEquipment>();
		lrEquipment.add(dumbbell);
										
		Collection<Muscle> lrMuscles = new ArrayList<Muscle>();
		lrMuscles.add(deltoids);
										
		lateralRaise.setMuscles(lrMuscles);
		lateralRaise.setTrainingEquipment(lrEquipment);
		ebr.save(lateralRaise);
		
		//-----------------------crunches-----------------------------------------
		ExerciseBuild crunches = new ExerciseBuild();
		crunches.setName("Crunches");
												
		Collection<Muscle> crunchesMuscles = new ArrayList<Muscle>();
		crunchesMuscles.add(abs);
		crunchesMuscles.add(moa);
												
		crunches.setMuscles(crunchesMuscles);
		ebr.save(crunches);
		
		//-----------------------side crunches-----------------------------------------
		ExerciseBuild sCrunches = new ExerciseBuild();
		sCrunches.setName("Side Crunches");
												
		Collection<Muscle> sCrunchesMuscles = new ArrayList<Muscle>();
		sCrunchesMuscles.add(abs);
		sCrunchesMuscles.add(moa);
												
		sCrunches.setMuscles(sCrunchesMuscles);
		ebr.save(sCrunches);
		
		//-----------------------zombie squats-----------------------------------------
		ExerciseBuild zombieSquats = new ExerciseBuild();
		zombieSquats.setName("Zombie Squats");
														
		Collection<Muscle> zSquatMuscles = new ArrayList<Muscle>();
		zSquatMuscles.add(legs);
		zSquatMuscles.add(glutes);
		zSquatMuscles.add(calves);
		zSquatMuscles.add(hipAdductor);
														
		zombieSquats.setMuscles(zSquatMuscles);
		ebr.save(zombieSquats);
		
		//-----------------------prisoner squats-----------------------------------------
		ExerciseBuild prisonerSquats = new ExerciseBuild();
		prisonerSquats.setName("Prisoner Squats");
																
		Collection<Muscle> pSquatMuscles = new ArrayList<Muscle>();
		pSquatMuscles.add(legs);
		pSquatMuscles.add(glutes);
		pSquatMuscles.add(hamstrings);
																
		prisonerSquats.setMuscles(pSquatMuscles);
		ebr.save(prisonerSquats);
		
		//-----------------------kick back-----------------------------------------
		ExerciseBuild kickBack = new ExerciseBuild();
		kickBack.setName("Kick Back");
		
		Collection<TrainingEquipment> kickBackEquipment = new ArrayList<TrainingEquipment>();
		kickBackEquipment.add(dumbbell);
																
		Collection<Muscle> kickBackMuscles = new ArrayList<Muscle>();
		kickBackMuscles.add(triceps);
							
		kickBack.setTrainingEquipment(kickBackEquipment);
		kickBack.setMuscles(kickBackMuscles);
		ebr.save(kickBack);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		
		init();
		
	}
}
