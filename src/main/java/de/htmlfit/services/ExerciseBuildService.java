package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import de.htmlfit.domain.ExerciseBuild;

public interface ExerciseBuildService {
	public void deleteById(long ID);
	public List<ExerciseBuild> findAll();
	public Optional<ExerciseBuild> findById(Long exerciseBuildId);
	public ExerciseBuild save(ExerciseBuild e);
}
