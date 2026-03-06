package de.htmlfit.domain;

import java.util.Collection;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

@Entity
public class TrainingEquipment {
	@Id
	@Column(name = "TRAININGEQUIPMENT_ID")
	@GeneratedValue
	private Long id;
	private String name;
	
	@JsonIgnore
	@Lob
	byte[] image;
	
	@ManyToMany
	@JoinTable(
			  name = "exercisesBuildTrainingEq", 
			  joinColumns = @JoinColumn(name = "TRAININGEQUIPMENT_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
	private Collection<ExerciseBuild> exerciseBuild;

	@ManyToMany
	private Collection<TrainingDay> trainingDays;
	
	public Collection<TrainingDay> getTrainingDays() {
		return trainingDays;
	}
	public void setTrainingDays(Collection<TrainingDay> trainingDaysPar) {
		trainingDays = trainingDaysPar;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TrainingEquipment other = (TrainingEquipment) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.id);
		return hash;
	}
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Collection<ExerciseBuild> getExerciseBuild() {
		return exerciseBuild;
	}
	public void setExerciseBuild(Collection<ExerciseBuild> exerciseBuild) {
		this.exerciseBuild = exerciseBuild;
	}
}
