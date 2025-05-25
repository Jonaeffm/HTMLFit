package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.htmlfit.domain.ProgramUser;
import de.htmlfit.domain.TrainingDay;
import de.htmlfit.repositories.TrainingDayRepository;

@Service
public class TrainingDayServiceImpl implements TrainingDayService{
	@Autowired
	private TrainingDayRepository repository;
	
	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		repository.deleteById(ID);
	}

	@Override
	public List<TrainingDay> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public List<TrainingDay> findByProgramUser(ProgramUser User) {
		// TODO Auto-generated method stub
		
		return repository.findByProgramUser(User);
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
