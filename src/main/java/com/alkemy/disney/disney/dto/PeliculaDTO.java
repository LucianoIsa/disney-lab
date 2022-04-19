package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PeliculaDTO {

    private String imagen;
    private String titulo;
    private String fechacreacion;
    private Long calificacion;

    private List<PersonajeDTO> personajes;


}
