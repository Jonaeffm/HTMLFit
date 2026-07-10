package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return (List<TrainingDay>) repository.findAll();
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


	 @Transactional  
	 public void deleteWithJoinCleanup(long id) 
	 {    
		 TrainingDay td = repository.findById(id).orElseThrow();
	 
	    
		 td.getExercise().clear();    
		 td.getExerciseBuild().clear();    
		 td.getEquip().clear();    
		 td.getMuscles().clear();
	    
		 repository.save(td);   // forces join-table updates in the transaction    
		 repository.delete(td); // or repo.deleteById(id)  
	 }
	
}
