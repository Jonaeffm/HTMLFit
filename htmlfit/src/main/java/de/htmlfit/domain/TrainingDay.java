package de.htmlfit.domain;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private TrainingPlan trainingPlan;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			  name = "exercises", 
			  joinColumns = @JoinColumn(name = "TRAININGDAY_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
	private Collection<Exercise> exercise;
	
	@JsonIgnore
	@OneToMany(mappedBy="TrainingDay")
	private Collection<ExerciseBuild> exerciseBuild;
	
}
