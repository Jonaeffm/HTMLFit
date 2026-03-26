package de.htmlfit.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.htmlfit.domain.Exercise;
import de.htmlfit.domain.Muscle;
import de.htmlfit.domain.TrainingDay;
import de.htmlfit.domain.TrainingEquipment;

@Service
public class MethodService{
	
	@Autowired
	private ExerciseService exerciseService;
	
	public Collection<Exercise> hiitExercises(TrainingDay td) {
		
		Collection<Muscle> selectedMuscles = td.getMuscles(); 
		Collection<TrainingEquipment> selectedEquipment = td.getEquip();
	
		Collection<Exercise> allExercises = exerciseService.findAll();
		Collection<Exercise> exercisesToAdd = new ArrayList<Exercise>();
		for(int i=0;i<4;i++) {
			int j=0;
			
			int k=0;
			
			Exercise exerciseToAdd = new Exercise();
			
			for(Exercise e : allExercises) {
				
				System.out.println("Exercise: "+e.getName());
				
				Collection<Muscle> eGetMuscles = e.getMuscles();
				
				for (Muscle m2 : eGetMuscles) {
					System.out.println("Exercise contains muscle "+ m2.getName());
				}
				
				for (Muscle m: selectedMuscles) {
					
					System.out.println("Muscle: "+m.getName());
					
					if (e.getMuscles().contains(m)) {
						k++;
					}
				}
				if(k>j) {
					j=k;
					exerciseToAdd = e;
					
					System.out.println("Ex2Add "+ exerciseToAdd.getName());
			

				}
			}
			allExercises.remove(exerciseToAdd);
			exercisesToAdd.add(exerciseToAdd);
			
			Collection<TrainingDay> trainingDays = exerciseToAdd.getTrainingDays();
			if (trainingDays == null || trainingDays.isEmpty()) {
				trainingDays = new ArrayList<TrainingDay>();
			}
			
			trainingDays.add(td);
			
			exerciseToAdd.setTrainingDays(trainingDays);
			
			exerciseService.save(exerciseToAdd);
		}
		
		return exercisesToAdd;
		
	}
	
}