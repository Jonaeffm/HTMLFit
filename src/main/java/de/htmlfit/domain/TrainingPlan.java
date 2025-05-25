package de.htmlfit.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TrainingPlan {
	@Id
	@Column(name = "TRAININGPLAN_ID")
	@GeneratedValue
	private Long id;
	/*@JsonIgnore
	@OneToMany(mappedBy="trainingPlan")
	private Collection<TrainingDay> trainingDays;*/
}
