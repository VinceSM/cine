package com.example.cine.controllers;

import com.example.cine.dtos.requests.PeliculaRequest;
import com.example.cine.dtos.responses.PeliculaResponse;
import com.example.cine.models.ActorModel;
import com.example.cine.services.ActorService;
import com.example.cine.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;
    private final ActorService actorService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService, ActorService actorService) {
        this.peliculaService = peliculaService;
        this.actorService = actorService;
    }

    @PostMapping("/crear")
    public ResponseEntity<PeliculaResponse> crearPelicula(@RequestBody PeliculaRequest peliculaRequest) {
        Optional<ActorModel> actorOptional = Optional.ofNullable(actorService.obtenerActorPorId(peliculaRequest.getIdActor()));
        if (actorOptional.isPresent()) {
            PeliculaResponse nuevaPelicula = peliculaService.crearPelicula(peliculaRequest, actorOptional.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPelicula);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PeliculaResponse>> listarPeliculas() {
        List<PeliculaResponse> peliculas = peliculaService.listarPeliculas();
        return ResponseEntity.ok(peliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaResponse> obtenerPeliculaPorId(@PathVariable Long id) {
        PeliculaResponse pelicula = peliculaService.obtenerPeliculaPorId(id);
        return ResponseEntity.ok(pelicula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return ResponseEntity.ok("Pelicula eliminada");
    }
}
