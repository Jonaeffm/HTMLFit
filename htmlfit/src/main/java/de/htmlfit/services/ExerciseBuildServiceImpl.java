package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.htmlfit.domain.ExerciseBuild;
import de.htmlfit.repositories.ExerciseBuildRepository;

@Service
public class ExerciseBuildServiceImpl implements ExerciseBuildService{
	@Autowired
	private ExerciseBuildRepository repository;

	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		repository.deleteById(ID);
	}
	
	public List<ExerciseBuild> findAll()
	{
		return repository.findAll();
	}
	
	public Optional<ExerciseBuild> findById(Long exerciseId)
	{
		return repository.findById(exerciseId);
	}
	
	public ExerciseBuild save(ExerciseBuild e)
	{
		return repository.save(e);
	}

}
