package com.alkemy.disney.disney.util.converter;

import com.alkemy.disney.disney.dto.genero.CrearGeneroDto;
import com.alkemy.disney.disney.modelo.Genero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GeneroDtoConverter {

    private final ModelMapper mapper;

    public Genero convertirCrearGeneroDtoAGenero(CrearGeneroDto generoDto) {
        return mapper.map(generoDto, Genero.class);
    }
}
