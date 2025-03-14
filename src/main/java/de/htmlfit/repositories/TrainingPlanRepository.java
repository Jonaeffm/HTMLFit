package de.htmlfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.htmlfit.domain.TrainingEquipment;
import de.htmlfit.domain.TrainingPlan;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long>{

}
