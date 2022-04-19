package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;


@Getter
@Setter
public class PersonajeBasicDto {
    private Long id;
    private String imagen;
    private String Nombre;

    @Override
    @Transactional
    public static class PeliculaDTO save(PeliculaDTO dto)
}
