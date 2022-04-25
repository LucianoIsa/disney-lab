package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.entity.PeliculaEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class PeliculaMapper {
    @Component
    public class PersonajeMapper {

        @Autowired
        private PeliculaMapper peliculaMapper;

        private PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto) {
            PeliculaEntity entity= new PeliculaEntity();
            entity.setImagen(dto.getImagen());
            entity.setTitulo(dto.getTitulo());
            entity.setFechaCreacion(this.string2LocalDate(dto.getFechaCreacion()));
            entity.setCalificacion(dto.getCalificacion());
            entity.setPersonajes(dto.getPersonajes());
            return entity;
        }

        public PeliculaDTO peliculaEntity2DTO(PeliculaEntity, boolean loadPeliculas){
            PeliculaDTO dto = new PeliculaDTO();
            Object entity;
            dto.setTitulo(entity.getTitulo());
            dto.setFechacreacion(entity.getFechaCreacion().toString());
            dto.setImagen(entity.getImagen());
            dto.setPersonajes(entity.getPersonajes());

            if (loadPeliculas){
                Object loadPersonajes;
                List<PeliculaDTO> peliculasDTO = this.peliculaMapper.peliculaEntityList2DTOList(entity.getPeliculas(), loadPersonajes: false);
                dto.setPeliculas(peliculasDTO);
            }
            return dto;
        }

        public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity> entities, boolean loadPersonajes){
            List<PeliculaDTO> dtos = new ArrayList<>();
            for (PeliculaEntity entity : entities) {
                dtos.add(this.peliculaEntity2DTO(entity, loadPersonajes));
            }
            return dtos;
        }
        public List<PeliculaEntity> peliculaDTOList2DTOEntity(@NotNull List<PeliculaEntity> dtos){
            List<PeliculaEntity> entities = new ArrayList<>();
            for (PeliculaDTO dto : dtos) {
                entities.add(this.peliculaDTO2Entity(dto));
            }
            return entities;
        }
}
