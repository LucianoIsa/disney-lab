package com.alkemy.disney.disney.util.converter;

import com.alkemy.disney.disney.dto.audiovisual.CrearAudiovisualDto;
import com.alkemy.disney.disney.dto.audiovisual.EditarAudiovisualDto;
import com.alkemy.disney.disney.dto.audiovisual.GetAudiovisualDto;
import com.alkemy.disney.disney.modelo.Audiovisual;
import com.alkemy.disney.disney.modelo.Pelicula;
import com.alkemy.disney.disney.modelo.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AudiovisualDtoConverter {

    private final ModelMapper mapper;

    public GetAudiovisualDto convertirAudiovisualAGetAudiovisualDto(Audiovisual audiovisual) {
        return mapper.map(audiovisual, GetAudiovisualDto.class);
    }

    public Audiovisual convertirCrearAudiovisualDtoAAudiovisual(CrearAudiovisualDto audiovisualDto) {
        if (audiovisualDto.getTipo().equalsIgnoreCase("pelicula")) {
            return mapper.map(audiovisualDto, Pelicula.class);
        } else {
            return mapper.map(audiovisualDto, Serie.class);
        }
    }

    public Audiovisual convertirEditarAudiovisualDtoAAudiovisual(EditarAudiovisualDto audiovisualDto,
                                                                 Audiovisual audiovisual) {
        mapper.map(audiovisualDto, audiovisual);
        return audiovisual;
    }
}
