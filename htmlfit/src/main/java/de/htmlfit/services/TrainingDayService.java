package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import de.htmlfit.domain.ProgramUser;
import de.htmlfit.domain.TrainingDay;
import de.htmlfit.repositories.TrainingDayRepository;;

public interface TrainingDayService {
	public void deleteById(long ID);
	public List<TrainingDay> findAll();
	public Optional<TrainingDay> findById(Long trainingDaytId);
	public List<TrainingDay> findByProgramUser(ProgramUser User);
	public TrainingDay save(TrainingDay e);
	public void deleteWithJoinCleanup(long id) ;

	
}
