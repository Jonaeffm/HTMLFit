package de.htmlfit.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,
	    property = "id"
	)
@Entity
public class ExerciseBuild {
	@Id
	@Column(name = "EXERCISE_ID")
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToMany()
	//@JsonIgnore
	private Collection<TrainingDay> TrainingDay;
	
	public Collection<TrainingDay> getTrainingDay() {
		return TrainingDay;
	}


	public void setTrainingDay(Collection<TrainingDay> trainingDay) {
		TrainingDay = trainingDay;
	}


	@JsonBackReference
	@ManyToMany()
	private Collection<Muscle> Muscles;
		
	
	@ManyToMany()
	private Collection<TrainingEquipment> TrainingEquipment;


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


	public Collection<TrainingEquipment> getTrainingEquipment() {
		return TrainingEquipment;
	}


	public void setTrainingEquipment(Collection<TrainingEquipment> trainingEquipment) {
		TrainingEquipment = trainingEquipment;
	}
}
