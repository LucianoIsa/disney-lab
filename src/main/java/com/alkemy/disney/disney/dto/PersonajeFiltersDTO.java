package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonajeFiltersDTO {
    private String name;
    private String age;
    private Set<Long> movies;
    private String order;

    public PersonajeFiltersDTO(String name, String age, Set<Long> movies, String order) {
        this.name = name;
        this.age = age;
        this.movies = movies;
        this.order = order;
    }

    public boolean isASC() { return this.order.compareToIgnoreCase( str: "ASC") == 0 ;}
    public boolean isDESC() { return this.order.compareToIgnoreCase( str: "DESC") == 0 ;}
}
