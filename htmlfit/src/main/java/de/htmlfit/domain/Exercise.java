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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	String name;
	@ManyToMany()
	Collection<Muscle> Muscles;
}
