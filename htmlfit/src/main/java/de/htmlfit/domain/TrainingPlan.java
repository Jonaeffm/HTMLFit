package de.htmlfit.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne()
	private ProgramUser programUser;
	
	@OneToMany
	@JoinTable(
	          name="TrainingDAys",
	          joinColumns = @JoinColumn( name="TRAININGPLAN_ID"),
	          inverseJoinColumns = @JoinColumn( name="TRAININGDAY_ID"))
	private Collection<TrainingDay> trainingDays;
	
	private String name;
}
