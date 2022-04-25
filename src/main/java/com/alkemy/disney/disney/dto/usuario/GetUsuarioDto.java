package com.alkemy.disney.disney.dto.usuario;

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
@ApiModel(description = "Envoltorio que se devuelve con el registro de un usuario, junto con su Jwt.")
public class GetUsuarioDto {

    @ApiModelProperty(value = "Nombre completo.", dataType = "String", example = "Luciano Isa", allowableValues = "range[6,100]", required = true, position = 1)
    @NotBlank
    @Size(min = 6, max = 100)
    private String nombreCompleto;

    @ApiModelProperty(value = "Nick para  logueo.", dataType = "String", example = "luciano22", allowableValues = "range[4,20]", required = true, position = 2)
    @NotBlank
    @Size(min = 4, max = 20)
    private String nombreUsuario;

    @ApiModelProperty(value = "Email", dataType = "String", example = "lucianoisabb@hotmail.com", required = true, position = 3)
    @Email
    @NotNull
    private String email;

    @ApiModelProperty(value = "Token para poder autenticarse con los permisos que posee el usuario.", dataType = "String", example = "AJDSLKLA144646454ASDADS556-ASDDASD151ADS", required = true, position = 4)
    private String token;
}
