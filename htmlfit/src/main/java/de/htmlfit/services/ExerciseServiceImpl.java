package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.htmlfit.domain.Exercise;
import de.htmlfit.repositories.ExerciseRepository;
@Service
public class ExerciseServiceImpl implements ExerciseService{
	@Autowired
	private ExerciseRepository repository;

	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		repository.deleteById(ID);
	}
	
	public List<Exercise> findAll()
	{
		return repository.findAll();
	}
	
	public Optional<Exercise> findById(Long exerciseId)
	{
		return repository.findById(exerciseId);
	}
	
	public Exercise save(Exercise e)
	{
		return repository.save(e);
	}

}
