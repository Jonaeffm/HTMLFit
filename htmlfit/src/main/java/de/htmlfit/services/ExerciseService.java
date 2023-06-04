package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import de.htmlfit.domain.Exercise;


public interface ExerciseService {
	public void deleteById(long ID);
	public List<Exercise> findAll();
	public Optional<Exercise> findById(Long muscleId);
	public Exercise save(Exercise e);
}
