package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.htmlfit.domain.TrainingEquipment;
import de.htmlfit.repositories.TrainingEquipmentRepository;

@Service
public class TrainingEquipmentServiceImpl implements TrainingEquipmentService {

	
	@Autowired
	private TrainingEquipmentRepository repository;
	
	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TrainingEquipment> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<TrainingEquipment> findById(Long trainingEquipmentId) {
		// TODO Auto-generated method stub
		return repository.findById(trainingEquipmentId);
	}

	@Override
	public TrainingEquipment save(TrainingEquipment e) {
		// TODO Auto-generated method stub
		return repository.save(e);
	}

}
