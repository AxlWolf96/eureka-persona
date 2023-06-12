package com.proyecto.personas.aplicacion.servicio;

import com.proyecto.personas.dominio.modelo.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> findAll();
    public Persona findById(Long id);
    Persona save(Persona persona);
    Persona update(Long id, Persona persona);
    void delete(Long id);
}
