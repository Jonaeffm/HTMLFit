package de.htmlfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.htmlfit.domain.Muscle;
import de.htmlfit.repositories.MuscleRepository;

@Service
public class MuscleServiceImpl implements MuscleService{
	@Autowired
	private MuscleRepository repository;

	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		repository.deleteById(ID);
	}
	
	public List<Muscle> findAll()
	{
		return repository.findAll();
	}
	
	public Optional<Muscle> findById(Long albumId)
	{
		return repository.findById(albumId);
	}
	
	public Muscle save(Muscle m)
	{
		return repository.save(m);
	}


}
