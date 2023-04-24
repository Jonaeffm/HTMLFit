package de.htmlfit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.picsheep.domain.Album;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Muscle {
	@Id
	@Column(name = "MUSCLE_ID")
	@GeneratedValue
	Long id;
	String name;
		
	@JsonProperty("exercise")
	@ManyToOne()
	private Exercise exercise;
}
