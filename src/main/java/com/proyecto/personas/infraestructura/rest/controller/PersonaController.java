package com.proyecto.personas.infraestructura.rest.controller;

import com.proyecto.personas.aplicacion.servicio.PersonaService;
import com.proyecto.personas.dominio.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona/v0")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/persona")
    public ResponseEntity<List<Persona>> findAll() {
        return new ResponseEntity<>(this.personaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/persona/{persona-id}")
    public ResponseEntity<Persona> findById(@PathVariable("persona-id") Long personaId) {
        return new ResponseEntity<>(personaService.findById(personaId), HttpStatus.OK);
    }

    @PostMapping("/persona")
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }

    @PutMapping("/persona/{persona-id}")
    public ResponseEntity<Persona> update(@PathVariable("persona-id") Long personaId, @RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.update(personaId, persona), HttpStatus.OK);
    }

    @DeleteMapping("/persona/{persona-id}")
    public void delete(@PathVariable("persona-id") Long personaId) {
        personaService.delete(personaId);
    }

}
