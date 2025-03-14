package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import de.htmlfit.domain.TrainingDay;;

public interface TrainingDayService {
	public void deleteById(long ID);
	public List<TrainingDay> findAll();
	public Optional<TrainingDay> findById(Long trainingDaytId);
	public TrainingDay save(TrainingDay e);
}
