package com.proyecto.personas.models.service;

import com.proyecto.personas.models.dao.PersonaDAO;
import com.proyecto.personas.models.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDAO personaDAO;
    
    @Override
    @Transactional(readOnly=true)
    public List<Persona> findAll() {
        return (List<Persona>) personaDAO.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Persona findById(Long id) {
        return personaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return personaDAO.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personaDAO.deleteById(id);
    }
}
