package com.proyecto.personas.controllers;

import com.proyecto.personas.models.entity.Persona;
import com.proyecto.personas.models.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona/v0")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/persona")
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/persona/{persona-id}")
    public Persona findById(@PathVariable("persona-id") Long personaId) {
        return personaService.findById(personaId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/persona")
    public Persona create(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/persona/{persona-id}")
    public Persona update(@PathVariable("persona-id") Long personaId, @RequestBody Persona persona) {

        Persona personaBD = personaService.findById(personaId);
        if (personaBD != null) {
            personaBD.setNombre(persona.getNombre());
            personaBD.setApellidoPaterno(persona.getApellidoPaterno());
            personaBD.setApellidoMaterno(persona.getApellidoMaterno());
            personaBD.setFechaNacimiento(persona.getFechaNacimiento());
            personaBD.setTipoDocumento(persona.getTipoDocumento());
            personaBD.setNumeroDocumento(persona.getNumeroDocumento());
            personaBD.setNumeroCelular(persona.getNumeroCelular());
            personaBD.setEmail(persona.getEmail());
        }
        return personaService.save(personaBD);
    }
    
    @DeleteMapping("/persona/{persona-id}")
    public void delete(@PathVariable("persona-id") Long personaId) {
        personaService.delete(personaId);
    }

}
