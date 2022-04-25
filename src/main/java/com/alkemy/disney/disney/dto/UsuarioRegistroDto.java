package com.alkemy.disney.disney.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ApiModel(description = "registro de un usuario.")
public class UsuarioRegistroDto {

    @ApiModelProperty(value = "Nombre completo del usuario.", dataType = "String", example = "Luciano Isa", allowableValues = "range[6,100]", required = true, position = 1)
    @NotBlank
    @Size(min = 6, max = 100)
    private String nombreCompleto;

    @ApiModelProperty(value = "Nombnre de usuario.Debe ser unico", dataType = "String", example = "Luciano1624", allowableValues = "range[4,20]", required = true, position = 2)
    @NotBlank
    @Size(min = 4, max = 20)
    private String nombreUsuario;

    @ApiModelProperty(value = "Contraseña usuario.", dataType = "String", example = "Luciano1624", allowableValues = "range[5,15]", required = true, position = 3)
    @NotBlank
    @Size(min = 5, max = 15)
    private String contrasena;

    @ApiModelProperty(value = "Repite contraseña", dataType = "String", example = "Luciano1624", allowableValues = "range[5,15]", required = true, position = 4)
    @NotBlank
    @Size(min = 5, max = 15)
    private String contrasenaRepetida;

    @ApiModelProperty(value = "Email", dataType = "String", example = "lucianoisabb@hotmail.com", required = true, position = 5)
    @NotNull
    @Email
    private String email;
}
