package de.htmlfit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.htmlfit.domain.ProgramUser;
import de.htmlfit.domain.TrainingDay;


public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long>{

	public List<TrainingDay> findByProgramUser(ProgramUser User);

}
