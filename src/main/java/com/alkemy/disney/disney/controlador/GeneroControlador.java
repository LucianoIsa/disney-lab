package com.alkemy.disney.disney.controlador;

import com.alkemy.disney.disney.dto.genero.CrearGeneroDto;
import com.alkemy.disney.disney.error.ApiError;
import com.alkemy.disney.disney.error.exception.ValidacionException;
import com.alkemy.disney.disney.modelo.Genero;
import com.alkemy.disney.disney.service.GeneroServicio;
import com.alkemy.disney.disney.util.converter.GeneroDtoConverter;
import com.alkemy.disney.disney.util.paginacion.PaginacionLinks;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GeneroControlador {

    private final GeneroServicio generoServicio;
    private final GeneroDtoConverter converter;
    private final PaginacionLinks paginacionLinks;

    @ApiOperation(value = "Mostrar los géneros",
            notes = "Muestro los géneros existentes."
                    + " Lo devuelve compaginado, y se puede cambiar el tamaño por defecto"
                    + " agregando una variable \"?size=\" y la dirección del orden con \"?direction\""
                    + " al path.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Genero.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found", response = ApiError.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)})

    @GetMapping
    public ResponseEntity<List<Genero>> listarGeneros(
            @ApiIgnore @PageableDefault(page = 0, size = 20, sort = "nombre") Pageable pageable,
            @ApiIgnore HttpServletRequest request) {
        Page<Genero> generos = generoServicio.buscarTodos(pageable);

        if (generos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

        return ResponseEntity.ok().header("link", paginacionLinks.crearLinkHeader(generos, builder))
                .body(generos.getContent());
    }

    @ApiOperation(value = "Crear un género",
            notes = "Creamos un género nuevo. Se necesitan permisos de administrador")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 201, message = "Created", response = Genero.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ApiError.class),
            @ApiResponse(code = 409, message = "Conflict", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)})

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Genero> nuevoGenero(
            @ApiParam(value = "Representacion Json del género que se desea crear.", required = true, type = "object")
            @Valid @RequestPart("genero") CrearGeneroDto generoDto,
            @ApiIgnore final Errors errores,
            @ApiParam(value = "Archivo de imagen que se guarda en el género.", required = false, type = "File")
            @RequestPart("imagen") MultipartFile imagen) {
        if(errores.hasErrors()) {
            throw new ValidacionException(errores.getAllErrors());
        }
        Genero genero = generoServicio
                .guardarImagenYAgregarUrlImagen(converter.convertirCrearGeneroDtoAGenero(generoDto), imagen);

        return ResponseEntity.status(HttpStatus.CREATED).body(generoServicio.guardar(genero));
    }
}
