package de.htmlfit.services;

import java.util.ArrayList;
import java.util.Collection;

import de.htmlfit.domain.Exercise;
import de.htmlfit.domain.Muscle;
import de.htmlfit.domain.TrainingDay;
import de.htmlfit.domain.TrainingEquipment;

public class MethodService{
	
	public ArrayList<Exercise> hiitExercises(TrainingDay td) {
		
		Collection<Muscle> selectedMuscles = td.getMuscles(); 
		Collection<TrainingEquipment> selectedEquipment = td.getEquip();
		
		return null;
		
	}
	
}