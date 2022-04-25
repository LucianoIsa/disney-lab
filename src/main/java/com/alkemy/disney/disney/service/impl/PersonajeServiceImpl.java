package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.entity.PeliculaEntity;
import com.alkemy.disney.disney.entity.PersonajeEntity;
import com.alkemy.disney.disney.exception.ParamNotFound;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.repository.PersonajeRepository;
import com.alkemy.disney.disney.repository.specifications.PersonajeSpecification;
import com.alkemy.disney.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    private PersonajeRepository personajeRepository;
    private PersonajeSpecification personajeSpecification;

    private PersonajeMapper personajeMapper;

    private PeliculaService peliculaService;

    @Autowired
    public PersonajeServiceImpl(
            PersonajeRepository personajeRepository,
            PersonajeSpecification personajeSpecification,
            PeliculaService peliculaService,
            PersonajeMapper personajeMapper) {
        this.personajeRepository = personajeRepository;
        this.personajeSpecification = personajeSpecification;
        this.personajeMapper = personajeMapper;
        this.peliculaService = peliculaService;
    }
    public PersonajeDTO getDetailsById(Long id) {
        Optional<PersonajeEntity> entity = this.personajeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id personaje no valido");

        }
        PersonajeDTO personajeDTO = this.personajeMapper.personajeEntity2DTO(entity.get(), true);
        return  personajeDTO;
    }
    public List<PersonajeBasicDto> getAll() {
        List<PersonajeEntity> entities = this.personajeRepository.findAll();
        List<PersonajeBasicDto> personajeBasicDtos = this.personajeMapper.personajeEntitySet2BasicDTOList(entities);
        return personajeBasicDtos;
    }
    public List<PersonajeDto> getByFiltersl(String name, String age, Set<Long> movies, String order) {
        PersonajeFiltersDTO filtersDTO = new personajeFiltersDto(name, age, movies, order);
        List<PersonajeEntity> entities = this.personajeRepository.findAll(this.personajeSpecification.getByFilters(filtersDTO));
        List<PersonajeDTO> dtos = this.personajeMapper.personajeEntitySet2DTOList(entities, true);
        return dtos;
    }
    public PersonajeDTO update(long id,PersonajeDTO personajeDTO){
        Optional <PersonajeEntity> entity = this.personajeRepository.findById(id);
        if (!entity.isPresent()){
            throw new ParamNotFound("ID icono no valido");
        }
        this.personajeMapper.peliculaEntityRefreshValues(entity.get(), peliculaDTO);
        PersonajeEntity entitySaved = this.personajeRepository.save(entity.get());
        PersonajeDTO result = this.personajeMapper.personajeEntity2DTO(entitySaved, false);
        return result;
    }
    public void addPelicula(Long id, Long idPelicula){
        PersonajeEntity entity = this.personajeRepository.getById(id);
        entity.getPeliculas().size();
        PeliculaEntity peliculaEntity = this.peliculaService.getPeliculaById(idPelicula);
        entity.addPelicula(peliculaEntity);
        this.peliculaRepository.save(entity);
    }
    public void removePelicula(Long id, Long idPelicula){
        PersonajeEntity entity = this.personajeRepository.getById(id);
        entity.getPeliculas().size();
        PeliculaEntity peliculaEntity = this.peliculaService.getPeliculaById(idPelicula);
        entity.removePelicula(peliculaEntity);
        this.peliculaRepository.save(entity);
    }
}
