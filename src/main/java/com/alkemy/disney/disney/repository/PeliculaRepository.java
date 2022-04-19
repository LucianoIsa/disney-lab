package com.alkemy.disney.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository<PeliculaEntity> extends JpaRepository<PeliculaEntity, Long> {
}
