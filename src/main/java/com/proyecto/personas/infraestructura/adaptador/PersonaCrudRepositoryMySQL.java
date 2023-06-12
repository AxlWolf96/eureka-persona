package com.proyecto.personas.infraestructura.adaptador;

import com.proyecto.personas.infraestructura.entidad.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaCrudRepositoryMySQL extends JpaRepository<PersonaEntity, Long> {
}
