package com.example.cine.mappers;

import com.example.cine.dtos.requests.PeliculaRequest;
import com.example.cine.dtos.responses.PeliculaResponse;
import com.example.cine.models.PeliculaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaMapper {
    @Autowired
    private ActorMapper actorMapper;

    public PeliculaModel mapToPeliculaModel(PeliculaRequest peliculaRequest) {
        PeliculaModel pelicula = new PeliculaModel();
        pelicula.setTitulo(peliculaRequest.getTitulo());
        pelicula.setIdActor(peliculaRequest.getIdActor());
        pelicula.setYear(peliculaRequest.getYear());
        pelicula.setDuracion(peliculaRequest.getDuracion());
        return pelicula;
    }

    public PeliculaResponse mapToPeliculaResponse(PeliculaModel pelicula) {
        PeliculaResponse peliculaResponse = new PeliculaResponse();
        peliculaResponse.setId(pelicula.getId());
        peliculaResponse.setTitulo(pelicula.getTitulo());
        peliculaResponse.setIdActor(pelicula.getIdActor());
        peliculaResponse.setYear(pelicula.getYear());
        peliculaResponse.setDuracion(pelicula.getDuracion());
        return peliculaResponse;
    }
}