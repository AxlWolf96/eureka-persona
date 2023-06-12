package com.proyecto.personas.dominio.puerto;

import com.proyecto.personas.dominio.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {

    public List<Persona> findAll();
    public Optional<Persona> findById(Long id);
    Persona save(Persona persona);
    Persona update(Long id, Persona persona);
    void delete(Long id);

}
