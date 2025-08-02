package de.htmlfit.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ExerciseBuild {
	@Id
	@Column(name = "EXERCISE_ID")
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToOne()
	@JsonIgnore
	private TrainingDay TrainingDay;
	
	@ManyToMany()
	private Collection<Muscle> Muscles;
		
	
	@ManyToMany()
	private Collection<TrainingEquipment> TrainingEquipment;
}
