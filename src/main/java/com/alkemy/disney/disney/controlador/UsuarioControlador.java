package com.alkemy.disney.disney.controlador;

import com.alkemy.disney.disney.dto.usuario.GetUsuarioDto;
import com.alkemy.disney.disney.modelo.Usuario;
import com.alkemy.disney.disney.modelo.objetonulo.UsuarioNulo;
import com.alkemy.disney.disney.service.UsuarioServicio;
import com.alkemy.disney.disney.util.converter.UsuarioDtoConverter;
import com.alkemy.disney.disney.util.paginacion.PaginacionLinks;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;
    private final UsuarioDtoConverter converter;
    private final PaginacionLinks paginacionLinks;

    @GetMapping
    public ResponseEntity<List<GetUsuarioDto>> listarUsuarios(
            @PageableDefault(page = 0, size = 50, sort = "nombreCompleto",direction = Sort.Direction.ASC)
                    Pageable pageable, HttpServletRequest request){
        Page<Usuario> usuarios = usuarioServicio.buscarTodos(pageable);

        if(usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
        List<GetUsuarioDto> getUsuariosDtos = usuarios.getContent().stream()
                .map(converter::convertirUsuarioAGetUsuarioDto)
                .collect(Collectors.toList());


        return ResponseEntity.status(HttpStatus.OK).header("link", paginacionLinks.crearLinkHeader(usuarios, builder))
                .body(getUsuariosDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUsuarioDto> obtenerUsuario(
            @PathVariable Long id){
        Usuario usuario = usuarioServicio.buscarPorId(id).orElse(UsuarioNulo.construir());

        if(usuario.esNulo()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(converter.convertirUsuarioAGetUsuarioDto(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GetUsuarioDto> borrarUsuario(
            @PathVariable Long id){
        if(!usuarioServicio.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioServicio.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
