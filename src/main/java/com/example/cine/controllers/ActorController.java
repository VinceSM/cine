package com.example.cine.controllers;

import com.example.cine.dtos.requests.ActorRequest;
import com.example.cine.dtos.responses.ActorResponse;
import com.example.cine.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/actores")
public class ActorController {

    @Autowired
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ActorResponse> crearActor(@RequestBody ActorRequest actorRequest) {
        ActorResponse nuevoActor = actorService.crearActor(actorRequest).getBody();
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoActor);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ActorResponse>> listarActores() {
        List<ActorResponse> actores = actorService.listarActores();
        return ResponseEntity.ok(actores);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarActor(@PathVariable("id") Long id) {
        actorService.eliminarActor(id);
        return ResponseEntity.ok("Actor eliminado");
    }
}
