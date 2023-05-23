package de.htmlfit.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Muscle {
	@Id
	@Column(name = "MUSCLE_ID")
	@GeneratedValue
	Long id;
	String name;
		
	@JsonIgnore
	@ManyToMany(mappedBy = "Muscles")
	private Collection<Exercise> exercise;
}
