package com.proyect.wolverine.controller;

import com.proyect.wolverine.entity.Persona;
import org.springframework.web.bind.annotation.*;
@RestController
public class PersonaController {

    // mostrar a todas las personas
    @GetMapping("/personas")
public  String getPersonas(){
    return "aquí todas las persona";
}
    //busque sólo una persona via ID
    @GetMapping("/personas/{id}")
    public  String getPersona(@PathVariable Long id){
    return "aquí una persona";
    }
    // agregue una persona
    @PostMapping("/personas")
    // modifique a la persona por medio de su ID
//el post guardará la información donde el método indique
    public String  createPersona( @RequestBody Persona persona){
    return "persona creada";
    }
    //modificación a la persona

    @PutMapping("/personas/{id}")
       public String modifyPersona(@RequestBody Persona persona, @PathVariable Long id){
         return "persona MODIFICADA";
     }

    //Elimine a una persona por medio de su ID
    @DeleteMapping("/personas/{id}")
    public String modifyPersona(@PathVariable Long id){
        return "persona MODIFICADA";
    }
    }




