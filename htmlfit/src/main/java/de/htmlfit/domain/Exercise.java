package de.htmlfit.domain;

import java.util.Collection;
import java.util.List;

import de.htmlfit.domain.Muscle;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Exercise {
	@Id
	@Column(name = "EXERCISE_ID")
	@GeneratedValue
	Long id;
	
	@OneToMany(targetEntity = Muscle.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "exercise_muscle", referencedColumnName = "EXERCISE_ID")
	Collection<Muscle> Muscles;
}
