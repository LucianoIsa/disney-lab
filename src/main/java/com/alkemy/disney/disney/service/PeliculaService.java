package com.alkemy.disney.disney.service;


import com.alkemy.disney.disney.entity.PeliculaEntity;

import java.util.List;
import java.util.Set;

public interface PeliculaService {
    PersonajeDTO getDetailsById(Long id);

    List<PersonajeBasicDto> getAll();
    List<PersonajeDTO> getByFilters(String name, String age, Set<Long> movies, String order);

    PersonajeDTO save(PersonajeDTO personajeDTO);
    PersonajeDTO update(Long id, PersonajeDTO personaje);

    void addPelicula(Long id, Long)

    PeliculaEntity getPeliculaById(Long idPelicula);
}

}
