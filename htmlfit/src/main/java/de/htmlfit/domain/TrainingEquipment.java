package de.htmlfit.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TrainingEquipment {
	@Id
	@Column(name = "TRAININGEQUIPMENT_ID")
	@GeneratedValue
	private Long id;
	private String name;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			  name = "exercisesBuildTrainingEq", 
			  joinColumns = @JoinColumn(name = "TRAININGEQUIPMENT_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
	private Collection<ExerciseBuild> exerciseBuild;

	public boolean equals(TrainingEquipment te) {
		return this.getId() == te.getId();
	}
	
}
