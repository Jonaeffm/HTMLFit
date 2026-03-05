package de.htmlfit.domain;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TrainingDay {
	@Id
	@Column(name = "TRAININGDAY_ID")
	@GeneratedValue
	private Long id;
	
	@ManyToOne()
	@JsonIgnore
	private ProgramUser programUser;

	@ManyToMany
	@JoinTable(
			  name = "exercisesTd", 
			  joinColumns = @JoinColumn(name = "TRAININGDAY_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
	private Collection<Exercise> exercise;
	
	@ManyToMany
	@JoinTable(
			  name = "musclesTd", 
			  joinColumns = @JoinColumn(name = "TRAININGDAY_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "MUSCLE_ID"))
	private Collection<Exercise> Muscles;

	@ManyToMany
	@JoinTable(
			  name = "TETd", 
			  joinColumns = @JoinColumn(name = "TRAININGDAY_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "TRAININGEQUIPMENT_ID"))
	private Collection<TrainingEquipment> Equip;
	
	@OneToMany
	@JoinTable(
	          name="BodyBuildExercises",
	          joinColumns = @JoinColumn( name="TRAININGDAY_ID"),
	          inverseJoinColumns = @JoinColumn( name="EXERCISE_ID"))
	private Collection<ExerciseBuild> exerciseBuild;

	@ManyToOne()
	@JsonIgnore
	private TrainingPlan TrainingPlan;
	
	@Override
	public String toString() {
		return "Training Day [id=" + id + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Muscle other = (Muscle) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
	
	public Collection<TrainingEquipment> getEquip() {
		return Equip;
	}

	public void setEquip(Collection<TrainingEquipment> equip) {
		Equip = equip;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.id);
		return hash;
	}


	public Collection<Exercise> getMuscles() {
		return Muscles;
	}

	public void setMuscles(Collection<Exercise> muscle) {
		Muscles = muscle;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProgramUser getProgramUser() {
		return programUser;
	}

	public void setProgramUser(ProgramUser programUser) {
		this.programUser = programUser;
	}

	public Collection<Exercise> getExercise() {
		return exercise;
	}

	public void setExercise(Collection<Exercise> exercise) {
		this.exercise = exercise;
	}

	public Collection<ExerciseBuild> getExerciseBuild() {
		return exerciseBuild;
	}

	public void setExerciseBuild(Collection<ExerciseBuild> exerciseBuild) {
		this.exerciseBuild = exerciseBuild;
	}

	public TrainingPlan getTrainingPlan() {
		return TrainingPlan;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		TrainingPlan = trainingPlan;
	}
}
