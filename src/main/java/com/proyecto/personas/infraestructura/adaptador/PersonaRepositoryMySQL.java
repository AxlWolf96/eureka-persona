package com.proyecto.personas.infraestructura.adaptador;

import com.proyecto.personas.dominio.modelo.Persona;
import com.proyecto.personas.dominio.puerto.PersonaRepository;
import com.proyecto.personas.infraestructura.entidad.PersonaEntity;
import com.proyecto.personas.infraestructura.excepciones.ResourceNotFoundException;
import com.proyecto.personas.infraestructura.rest.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepositoryMySQL implements PersonaRepository {

    @Autowired
    private PersonaCrudRepositoryMySQL personaCrudRepositoryMySQL;

    @Autowired
    private PersonaMapper personaMapper;


    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return personaMapper.toPersonas(personaCrudRepositoryMySQL.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Long id) {
        PersonaEntity persona = personaCrudRepositoryMySQL.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso no encontrado")
        );

        return Optional.of(personaMapper.toPersona(persona));
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        PersonaEntity personaEntity = personaMapper.toPersonaEntity(persona);
        return personaMapper.toPersona(personaCrudRepositoryMySQL.save(personaEntity));
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona persona) {

        PersonaEntity personaEntityDB = personaCrudRepositoryMySQL.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso no encontrado")
        );

        PersonaEntity personaEntityNew = personaMapper.toPersonaEntity(persona);

        personaEntityDB.setNombre(personaEntityNew.getNombre());
        personaEntityDB.setApellidoPaterno(personaEntityNew.getApellidoPaterno());
        personaEntityDB.setApellidoMaterno(personaEntityNew.getApellidoMaterno());
        personaEntityDB.setFechaNacimiento(personaEntityNew.getFechaNacimiento());
        personaEntityDB.setTipoDocumento(personaEntityNew.getTipoDocumento());
        personaEntityDB.setNumeroDocumento(personaEntityNew.getNumeroDocumento());
        personaEntityDB.setNumeroCelular(personaEntityNew.getNumeroCelular());
        personaEntityDB.setEmail(personaEntityNew.getEmail());

        return personaMapper.toPersona(personaCrudRepositoryMySQL.save(personaEntityDB));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        PersonaEntity personaEntity = personaCrudRepositoryMySQL.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso no encontrado")
        );
        personaCrudRepositoryMySQL.deleteById(personaEntity.getId());
    }
}
