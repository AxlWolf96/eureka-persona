package com.proyecto.personas.models.dao;

import com.proyecto.personas.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDAO extends JpaRepository<Persona, Long> {
}
