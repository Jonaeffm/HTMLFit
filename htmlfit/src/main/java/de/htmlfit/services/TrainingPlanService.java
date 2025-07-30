package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import de.htmlfit.domain.ProgramUser;
import de.htmlfit.domain.TrainingDay;
import de.htmlfit.domain.TrainingPlan;

public interface TrainingPlanService {
	public void deleteById(long ID);
	public List<TrainingPlan> findAll();
	public Optional<TrainingPlan> findById(Long trainingPlanId);
	public List<TrainingPlan> findByProgramUser(ProgramUser User);
	public TrainingPlan save(TrainingPlan e);
}
