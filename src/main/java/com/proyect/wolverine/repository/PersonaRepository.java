package com.proyect.wolverine.repository;

import com.proyect.wolverine.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

Persona getPersonaById(Long id);
}
