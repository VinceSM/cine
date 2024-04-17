package com.example.cine.services;

import com.example.cine.dtos.requests.ActorRequest;
import com.example.cine.dtos.responses.ActorResponse;
import com.example.cine.mappers.ActorMapper;
import com.example.cine.models.ActorModel;
import com.example.cine.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorMapper actorMapper;

    public ResponseEntity<ActorResponse> crearActor(@RequestBody ActorRequest actorRequest) {
        ActorModel actor = actorMapper.mapToActorModel(actorRequest);
        ActorModel nuevoActor = actorRepository.save(actor);
        ActorResponse actorResponse = actorMapper.mapToActorResponse(nuevoActor);
        return ResponseEntity.ok(actorResponse);
    }

    public List<ActorResponse> listarActores() {
        List<ActorModel> autores = actorRepository.findAll();
        return autores.stream()
                .map(actorMapper::mapToActorResponse)
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> eliminarActor(Long id) {
        Optional<ActorModel> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()) {
            actorRepository.deleteById(id);
            return ResponseEntity.ok("Actor eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ActorModel obtenerActorPorId(Long idActor) {
        Optional<ActorModel> actorOptional = actorRepository.findById(idActor);
        if (actorOptional.isPresent()) {
            return actorOptional.get();
        } else {
            throw new IllegalArgumentException("El actor con el ID proporcionado no existe");
        }
    }


}
