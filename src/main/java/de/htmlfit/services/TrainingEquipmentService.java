package de.htmlfit.services;

import java.util.List;
import java.util.Optional;


import de.htmlfit.domain.TrainingEquipment;

public interface TrainingEquipmentService {
	public void deleteById(long ID);
	public List<TrainingEquipment> findAll();
	public Optional<TrainingEquipment> findById(Long trainingEquipmentId);
	public TrainingEquipment save(TrainingEquipment e);
}
