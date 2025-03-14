package de.htmlfit.domain;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class NumberBean {
	@Id
	@Column(name = "NUMBER_ID")
	@GeneratedValue
	Long id;
	int count;
}
