package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.htmlfit.domain.ProgramUser;
import de.htmlfit.domain.TrainingPlan;
import de.htmlfit.repositories.TrainingPlanRepository;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService{
	@Autowired
	private TrainingPlanRepository repository;
	
	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TrainingPlan> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<TrainingPlan> findById(Long trainingPlanId) {
		// TODO Auto-generated method stub
		return repository.findById(trainingPlanId);
	}

	@Override
	public TrainingPlan save(TrainingPlan e) {
		// TODO Auto-generated method stub
		return repository.save(e);
	}

	
	@Override
	public List<TrainingPlan> findByProgramUser(ProgramUser User) {
		// TODO Auto-generated method stub
		
		return repository.findByProgramUser(User);
	}

}
