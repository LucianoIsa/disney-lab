package com.alkemy.disney.disney.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.alkemy.disney.disney.util.serializador.PersonajeSerializador;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Modela a los personajes.")
public class Personaje {

    @ApiModelProperty(value = "Id del personaje.", dataType = "long", example = "1", allowableValues = "range[1,infinity]", required = true, position = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Url de la imagen del personaje.", dataType = "String", example = "http://fotos.com.ar/files/rambo3", required = false, position = 2)
    private String urlImagen;

    @ApiModelProperty(value = "Nombre del personaje.", dataType = "String", example = "Rambo",allowableValues = "range[1,50]" , required = true, position = 3)
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String nombre;

    @ApiModelProperty(value = "Edad del personaje.", dataType = "int", example = "41", allowableValues = "range[0,200]", required = true, position = 4)
    @Min(0)
    @Max(200)
    @NotNull
    private int edad;

    @ApiModelProperty(value = "Peso del personaje.", dataType = "double", example = "90", allowableValues = "range[0,5000]", required = true, position = 5)
    @Min(0)
    @Max(5000)
    @NotNull
    private double peso;

    @ApiModelProperty(value = "resumen del personaje.", dataType = "String", example = "Rambo, es un mercenario, del gobierno norteamericano, que lucha por su gobierno y sus ideales.Protagonizada por Sylvester Stalonne, en 5 versiones.", allowableValues = "range[infinity,1500]", required = false, position = 6)
    @Size(max = 1500)
    private String historia;

    @ApiModelProperty(value = "Lista de las películas en la que se encuentra el personaje.", dataType = "List", required = false, position = 7)
    @ManyToMany(mappedBy = "personajes")
    @JsonSerialize(using = PersonajeSerializador.class)
    private List<Audiovisual> audiovisuales;

    public boolean esNulo() {
        return false;
    }
}
