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

@Entity
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

	public Collection<TrainingDay> getTrainingDays() {
		return trainingDays;
	}

	public void setTrainingDays(Collection<TrainingDay> trainingDays) {
		this.trainingDays = trainingDays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
