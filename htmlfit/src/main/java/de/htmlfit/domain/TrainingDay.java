package de.htmlfit.domain;

import java.util.Collection;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

	@OneToMany
	@JoinTable(
	          name="BodyBuildExercises",
	          joinColumns = @JoinColumn( name="TRAININGDAY_ID"),
	          inverseJoinColumns = @JoinColumn( name="EXERCISE_ID"))
	private Collection<ExerciseBuild> exerciseBuild;

	@ManyToOne()
	@JsonIgnore
	private TrainingPlan TrainingPlan;
}
