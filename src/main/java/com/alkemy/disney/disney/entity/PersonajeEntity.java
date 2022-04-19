package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@SQLDelete(sql ="UPDATE personaje SET deletd = true WHERE id=?")
@Where(clause = "deleted-false")
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private Long edad;

    private Long peso;

    private String historia;


    @ManyToMany(mappedBy = "personajes")



    private List<PeliculaEntity> peliculas = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;
    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL )
    public void addPelicula(PeliculaEntity pelicula) { this.peliculas.add(pelicula);}
    public void removePelicula(PeliculaEntity pelicula) { this.peliculas.remove(pelicula);}



}
