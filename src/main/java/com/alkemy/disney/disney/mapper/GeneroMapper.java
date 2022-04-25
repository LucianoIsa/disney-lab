package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.entity.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO dto){
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setPeliculasAsociada(dto.getPeliculasAsociada());
        return generoEntity;
    }
    public GeneroDTO generoEntity2DTO(GeneroEntity entity){
        GeneroDTO dto = new GeneroDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setPeliculasAsociada(entity.getPeliculasAsociada());
        return dto;
    }
    public List<GeneroDTO> generoEntityList2DTOList(List<GeneroEntity> entities){
        List<GeneroDTO> dtos = new ArrayList<>();
        for (GeneroEntity entity : entities){
            dtos.add(this.generoEntity2DTO(entity));
        }
        return dtos;
    }



}

