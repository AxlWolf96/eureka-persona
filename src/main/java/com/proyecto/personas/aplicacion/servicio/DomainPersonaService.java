package com.proyecto.personas.aplicacion.servicio;

import com.proyecto.personas.dominio.modelo.Persona;
import com.proyecto.personas.dominio.puerto.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainPersonaService implements PersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(id).get();
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Long id, Persona persona) {
        return personaRepository.update(id, persona);
    }

    @Override
    public void delete(Long id) {
        personaRepository.delete(id);
    }
}
