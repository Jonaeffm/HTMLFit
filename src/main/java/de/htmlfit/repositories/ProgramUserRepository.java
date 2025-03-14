package de.htmlfit.repositories;

import org.springframework.data.repository.CrudRepository;

import de.htmlfit.domain.ProgramUser;




public interface ProgramUserRepository extends CrudRepository<ProgramUser, Long> {
    ProgramUser findByUsername(String username);
}