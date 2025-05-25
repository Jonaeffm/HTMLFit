package de.htmlfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.htmlfit.domain.Exercise;
import de.htmlfit.domain.Muscle;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
