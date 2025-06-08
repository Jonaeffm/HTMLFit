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
	@Lob
	byte[] image;
	
	@ManyToMany
	@JoinTable(
			  name = "exercisesBuildTrainingEq", 
			  joinColumns = @JoinColumn(name = "TRAININGEQUIPMENT_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
	private Collection<ExerciseBuild> exerciseBuild;

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
}
