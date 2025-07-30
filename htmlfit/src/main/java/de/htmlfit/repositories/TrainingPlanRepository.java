package de.htmlfit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.htmlfit.domain.ProgramUser;
import de.htmlfit.domain.TrainingDay;
import de.htmlfit.domain.TrainingEquipment;
import de.htmlfit.domain.TrainingPlan;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long>{

	public List<TrainingPlan> findByProgramUser(ProgramUser User);
	
}
