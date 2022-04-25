package com.alkemy.disney.disney.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Logeo del usuario.")
public class UsuarioLoginDto {

    @ApiModelProperty(value = "Nombre de usuario. Debe ser unico.", dataType = "String", example = "Luciano Isa", allowableValues = "range[4,20]", required = true, position = 1)
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;

    @ApiModelProperty(value = "Contraseña", dataType = "String", example = "Luciano1624", allowableValues = "range[5,15]", required = true, position = 2)
    @NotBlank
    @Size(min = 5, max = 15)
    private String password;
}
