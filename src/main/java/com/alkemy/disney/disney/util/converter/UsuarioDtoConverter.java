package com.alkemy.disney.disney.util.converter;

import org.modelmapper.ModelMapper;
import com.alkemy.disney.disney.dto.UsuarioRegistroDto;
import com.alkemy.disney.disney.dto.usuario.GetUsuarioDto;
import com.alkemy.disney.disney.modelo.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioDtoConverter {

    private final ModelMapper mapper;

    public Usuario convertirUsuarioRegistroDtoAUsuario(UsuarioRegistroDto usuarioDto) {
        return mapper.map(usuarioDto, Usuario.class);
    }

    public GetUsuarioDto convertirUsuarioAGetUsuarioDto(Usuario usuario) {
        return mapper.map(usuario, GetUsuarioDto.class);
    }
}
