package com.example.cine.services;

import com.example.cine.dtos.requests.PeliculaRequest;
import com.example.cine.dtos.responses.PeliculaResponse;
import com.example.cine.mappers.PeliculaMapper;
import com.example.cine.models.ActorModel;
import com.example.cine.models.PeliculaModel;
import com.example.cine.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private PeliculaMapper peliculaMapper;

    @Transactional
    public PeliculaResponse crearPelicula(PeliculaRequest peliculaRequest, ActorModel actor) {
        PeliculaModel pelicula = new PeliculaModel();
        pelicula.setIsbn(peliculaRequest.getIsbn());
        pelicula.setTitulo(peliculaRequest.getTitulo());
        pelicula.setIdActor(peliculaRequest.getIdActor());

        PeliculaModel peliculaGuardada = peliculaRepository.save(pelicula);

        return peliculaMapper.mapToPeliculaResponse(peliculaGuardada);
    }

    @Transactional(readOnly = true)
    public List<PeliculaResponse> listarPeliculas() {
        List<PeliculaModel> peliculas = peliculaRepository.findAll();
        return peliculas.stream()
                .map(peliculaMapper::mapToPeliculaResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }

    public PeliculaResponse obtenerPeliculaPorId(Long id) {
        PeliculaModel pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula no encontrada con id: " + id));

        return peliculaMapper.mapToPeliculaResponse(pelicula);
    }
}
