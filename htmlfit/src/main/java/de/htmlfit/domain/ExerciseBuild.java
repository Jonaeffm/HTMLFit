package de.htmlfit.domain;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	@ManyToMany()
	private Collection<Muscle> Muscles;
}
