package com.proyecto.personas.models.service;

import com.proyecto.personas.models.entity.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> findAll();
    public Persona findById(Long id);
    Persona save(Persona persona);
    void delete(Long id);
}
