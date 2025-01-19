package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import de.htmlfit.domain.TrainingDay;
import de.htmlfit.repositories.TrainingDayRepository;

public class TrainingDayServiceImpl implements TrainingDayService{
	@Autowired
	private TrainingDayRepository repository;
	
	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TrainingDay> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<TrainingDay> findById(Long trainingDayId) {
		// TODO Auto-generated method stub
		return repository.findById(trainingDayId);
	}

	@Override
	public TrainingDay save(TrainingDay e) {
		// TODO Auto-generated method stub
		return repository.save(e);
	}

}
