package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.PersonajeBasicDto;
import com.alkemy.disney.disney.dto.PersonajeDTO;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    private PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeBasicDto>> getAll() {
        List<PersonajeBasicDto> personajes = this.personajeService.getAll();
        return ResponseEntity.ok(personajes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> getDetailsById(@PathVariable Long id) {
        PersonajeDTO personaje = this.personajeService.getDetailsById(id);
        return ResponseEntity.ok(personaje);
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getDetailsByIdFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) Set<Long> movies,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<PersonajeDTO> personajes = this.personajeService.getByFilters(name, age, movies, order);
        return ResponseEntity.ok(personajes);
    }

    @PostMapping
    public  ResponseEntity<PersonajeDTO>  save(@RequestBody PersonajeDTO personaje) {
        PersonajeDTO result = this.personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<PersonajeDTO> update(@PathVariable Long id, @RequestBody PersonajeDTO personaje) {
        PersonajeDTO result = this.personajeService.update(id ,personaje);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void>  delete(@PathVariable Long id) {
        this.personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/pelicula/{idPelicula}")
    public  ResponseEntity<Void>  addPelicula(@PathVariable Long id, @PathVariable Long idPelicula ) {
        this.personajeService.addPelicula(id, idPelicula);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/pelicula/{idPelicula}")
    public  ResponseEntity<Void>  removePelicula(@PathVariable Long id, @PathVariable Long idPelicula ) {
        this.personajeService.removePelicula(id, idPelicula);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
