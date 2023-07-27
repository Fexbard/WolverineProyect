package com.proyect.wolverine.controller;

import com.proyect.wolverine.entity.Persona;
import com.proyect.wolverine.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PersonaController {

    @Autowired
     PersonaRepository personaRepository;

    // mostrar a todas las personas
    @GetMapping("/personas")
public List<Persona> getPersonas(){
        return personaRepository.findAll();
}
    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable Long id){
    Persona personaEncontrada = personaRepository.getPersonaById(id);
    return ResponseEntity.ok(personaEncontrada);
    };

    @PostMapping("/personas")
    public ResponseEntity<Persona> createPersona( @RequestBody Persona persona){
        personaRepository.save(persona);
    return ResponseEntity.ok().build();
    }

    @PutMapping("/personas/{id}")
       public ResponseEntity<?> modifyPersona(@RequestBody Persona personaUpdate, @PathVariable Long id){
        Persona personaEncontrada = personaRepository.getPersonaById(id);

        personaEncontrada.setName(personaUpdate.getName());
        personaEncontrada.setLastName(personaUpdate.getLastName());
        personaEncontrada.setEmail(personaUpdate.getEmail());
        personaEncontrada.setPhone(personaUpdate.getPhone());
        personaEncontrada.setAddress(personaUpdate.getAddress());
        personaEncontrada.setDni(personaUpdate.getDni());
        Persona personaModificada = personaRepository.save(personaEncontrada);

    return ResponseEntity.ok().build();
     }

    @DeleteMapping("/personas/{id}")
    public String modifyPersona(@PathVariable Long id){
        Persona personaEliminar = personaRepository.getPersonaById(id);
        personaRepository.delete(personaEliminar);
        return "El usuario"+personaEliminar+ "ha sido eliminado";
    }
    }




