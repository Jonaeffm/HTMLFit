package de.htmlfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.htmlfit.domain.Muscle;


public interface MuscleRepository extends JpaRepository<Muscle, Long> {

}
