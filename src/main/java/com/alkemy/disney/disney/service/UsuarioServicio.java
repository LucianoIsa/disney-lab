package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio extends BaseServicio<Usuario, Long, UsuarioRepositorio> {

    public UsuarioServicio(UsuarioRepositorio repositorio) {
        super(repositorio);
    }

    public Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario){
        return this.repositorio.findByNombreUsuario(nombreUsuario);
    }

    public boolean existePorNombreUsuario(String nombreUsuario) {
        return this.repositorio.existsByNombreUsuario(nombreUsuario);
    }
}
