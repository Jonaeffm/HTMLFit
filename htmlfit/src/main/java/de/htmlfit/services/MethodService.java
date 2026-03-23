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
				
				for (Muscle m: selectedMuscles) {
					if (e.getMuscles().contains(m)) {
						k++;
					}
				}
				if(k>j) {
					j=k;
					exerciseToAdd = e;
					
			

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