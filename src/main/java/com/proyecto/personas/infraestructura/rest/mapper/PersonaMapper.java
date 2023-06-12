package com.proyecto.personas.infraestructura.rest.mapper;

import com.proyecto.personas.dominio.modelo.Persona;
import com.proyecto.personas.infraestructura.entidad.PersonaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    
    
    Persona toPersona(PersonaEntity personaEntity);
    List<Persona> toPersonas(List<PersonaEntity> personaEntity);
    PersonaEntity toPersonaEntity(Persona persona);
    
}
