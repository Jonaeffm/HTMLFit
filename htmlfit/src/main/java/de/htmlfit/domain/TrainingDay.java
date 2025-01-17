package de.htmlfit.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

	@JsonIgnore
	@ManyToMany(mappedBy = "TrainingDays")
	private Collection<Exercise> exercise;
	
	@JsonIgnore
	@OneToMany(mappedBy="TrainingDay")
	private Collection<ExerciseBuild> exerciseBuild;
	
}
