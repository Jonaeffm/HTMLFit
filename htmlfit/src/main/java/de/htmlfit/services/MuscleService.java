package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import de.htmlfit.domain.Muscle;


public interface MuscleService{
	
public void deleteById(long ID);
public List<Muscle> findAll();
public Optional<Muscle> findById(Long muscleId);
public Muscle save(Muscle m);
}	


