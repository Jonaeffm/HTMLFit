package de.htmlfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.htmlfit.domain.TrainingDay;

public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long>{

}
