package de.htmlfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.htmlfit.domain.TrainingEquipment;

public interface TrainingPlanRepository extends JpaRepository<TrainingEquipment, Long>{

}
