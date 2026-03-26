package de.htmlfit.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.htmlfit.domain.Muscle;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Exercise {
	@Id
	@Column(name = "EXERCISE_ID")
	@GeneratedValue
	private Long id;
	
	private String name;
	@ManyToMany(mappedBy = "exercise")
	private Collection<Muscle> Muscles;
	@ManyToMany(mappedBy = "exercise")
	private Collection<TrainingDay> TrainingDays;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Muscle> getMuscles() {
		return Muscles;
	}
	public void setMuscles(Collection<Muscle> muscles) {
		Muscles = muscles;
	}
	public Collection<TrainingDay> getTrainingDays() {
		return TrainingDays;
	}
	public void setTrainingDays(Collection<TrainingDay> trainingDays) {
		TrainingDays = trainingDays;
	}
	
}
