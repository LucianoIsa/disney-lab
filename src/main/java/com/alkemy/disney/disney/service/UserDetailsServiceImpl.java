package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.modelo.Usuario;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("UserDetailsService")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioServicio.buscarPorNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException(nombreUsuario + " no encontrado."));

        Collection<SimpleGrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.name())).collect(Collectors.toList());

        return new User(usuario.getNombreUsuario(), usuario.getContrasena(), authorities);
    }
}
