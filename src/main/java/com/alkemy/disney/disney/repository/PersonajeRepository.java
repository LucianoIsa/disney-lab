package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.entity.PersonajeEntity;
import com.alkemy.disney.disney.modelo.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long>, JpaSpecificationExecutor<Personaje> {

    Optional<Personaje> findByNombre(String string);

    Optional<Personaje> findByNombreIgnoreCase (String string);

    boolean existsByNombreIgnoreCase(String nombre);
}
