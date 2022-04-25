package com.alkemy.disney.disney.util.converter;

import com.alkemy.disney.disney.dto.personaje.CrearYEditarPersonajeDto;
import com.alkemy.disney.disney.dto.personaje.GetPersonajeDto;
import com.alkemy.disney.disney.modelo.Personaje;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonajeDtoConverter {

    private final ModelMapper mapper;

    public Personaje convertirCrearYEditarPersonajeDtoAPersonaje(CrearYEditarPersonajeDto personajeDto) {
        return mapper.map(personajeDto, Personaje.class);
    }

    public Personaje convertirCrearYEditarPersonajeDtoAPersonaje(CrearYEditarPersonajeDto personajeDto,
                                                                 Personaje personaje) {
        mapper.map(personajeDto, personaje);
        return personaje;
    }

    public GetPersonajeDto convertirPersonajeAGetPersonajeDto(Personaje personaje) {
        return mapper.map(personaje, GetPersonajeDto.class);
    }
}
