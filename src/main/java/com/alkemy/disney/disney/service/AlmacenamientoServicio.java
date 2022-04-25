package com.alkemy.disney.disney.service;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface AlmacenamientoServicio {

    void init();

    String guardar(MultipartFile file);

    Stream<Path> obtenerTodasLasRutas();

    Path obtenerRuta(String filename);

    Resource cargarComoResource(String filename);

    void borrar(String filename);

    void borrarTodos();
}

