package com.alkemy.disney.disney.dto.audiovisual;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GetAudiovisualDto {

    @ApiModelProperty(value = "Url de la imagen de la película", dataType = "String", example = "http://miweb.com.ar/files/imageAvengers", required = false, position = 1)
    private String urlImagen;

    @ApiModelProperty(value = "Título de la película", dataType = "String", example = "Avengers", allowableValues = "range[1,150]", required = true, position = 2)
    @NotBlank
    @Size(max = 150)
    private String titulo;

    @ApiModelProperty(value = "Fecha de la película", dataType = "LocalDate", example = "1995-06-16", required = true, position = 3)
    @NotNull
    private LocalDate fechaDeEstreno;
}
