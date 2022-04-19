package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
@Where(clause = "delete=false")
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Transient
    private LocalDate fechaCreacion;

    private Long calificacion; // 1 al 5

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

    @Column(name = "genero_id", nullable = false)
    private Long generoId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name ="personaje_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<PersonajeEntity> personajes = new HashSet<>();

    private boolean deleted = Boolean.FALSE;

    public void addCharacter(PersonajeEntity personaje) {
        this.personajes.add(personaje);
    }
    public void removeCharacter(PersonajeEntity personaje) {
        this.personajes.remove(personaje);
    }




}
