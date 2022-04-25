package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.entity.PeliculaEntity;
import com.alkemy.disney.disney.entity.PersonajeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
    public class PersonajeMapper {

        @Autowired
        private PeliculaMapper peliculaMapper;

        private PersonajeEntity personajeDTO2Entity(PersonajeDTO dto) {
        PersonajeEntity entity= new PersonajeEntity();
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        entity.setEdad(this.String(dto.getEdad()));
        entity.setPeso(dto.getPeso());
        entity.setHistoria(dto.getHistoria());
        entity.setPeliculas(dto.getPeliculas());
        return entity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity, boolean loadPeliculas){
            PersonajeDTO dto = new PersonajeDTO();
            Object entity;
            dto.setNombre(entity.getNombre());
            dto.setEdad(entity.getEdad());
            dto.setImagen(entity.getImagen());
            dto.setHistoria(entity.getHistoria());
            dto.setPeliculas(entity.getPeliculas());
            dto.setPeso(entity.getPeso());
            if (loadPeliculas){
                List<PeliculaDTO> peliculasDTO = this.peliculaMapper.peliculaEntityList2DTOList(entity.getPeliculas(), loadPersonajes: false);
                dto.setPeliculas(peliculasDTO);
            }
            return dto;


    }
    private Long String(Long edad) {}

    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity> entities, boolean loadPersonajes){
            List<PeliculaDTO> dtos = new ArrayList<>();
            for (PeliculaEntity entity : entities) {
                dtos.add(this.peliculaEntity2DTO(entity, loadPersonajes));
            }
            return dtos;
    }

    private PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity, boolean loadPersonajes) {
    }

    public List<PeliculaEntity> peliculaDTOList2DTOEntity(@NotNull List<PeliculaEntity> dtos){
        List<PeliculaEntity> entities = new ArrayList<>();
        for (PeliculaDTO dto : dtos) {
            entities.add(this.peliculaDTO2Entity(dto));
        }
        return entities;
}

    private PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto) {
    }

    public List<PersonajeBasicDto> personajeEntitySet2BasicDTOList(List<PersonajeEntity> entities) {
    }
