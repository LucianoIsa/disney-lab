package com.alkemy.disney.disney.dto.personaje;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CrearYEditarPersonajeDto {

    @ApiModelProperty(value = "Nombre del personaje.", dataType = "String", example = "Terminator", allowableValues = "range[1,50]", required = true, position = 1)
    @NotBlank
    @Size(max = 50)
    private String nombre;

    @ApiModelProperty(value = "Edad del personaje.", dataType = "int", example = "18", allowableValues = "range[0,200]", required = true, position = 2)
    @Min(0)
    @Max(200)
    @NotNull
    private int edad;

    @ApiModelProperty(value = "Peso del personaje.", dataType = "double", example = "60", allowableValues = "range[0,5000]", required = true, position = 3)
    @Min(0)
    @Max(5000)
    @NotNull
    private double peso;


    @ApiModelProperty(value = "resumen del personaje.", dataType = "String", example = "Terminator viene del futuro, para luchar contra las corporaciones.", allowableValues = "range[infinity,1500]", required = false, position = 4)
    @Size(max = 1500)
    private String historia;
}
