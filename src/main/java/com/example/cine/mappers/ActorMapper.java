package com.example.cine.mappers;

import com.example.cine.dtos.requests.ActorRequest;
import com.example.cine.dtos.responses.ActorResponse;
import com.example.cine.models.ActorModel;
import org.springframework.stereotype.Service;

@Service
public class ActorMapper {
    public ActorModel mapToActorModel(ActorRequest actorRequest) {
        ActorModel actor = new ActorModel();
        actor.setNombre(actorRequest.getNombre());
        actor.setApellido(actorRequest.getApellido());
        return actor;
    }

    public ActorResponse mapToActorResponse(ActorModel nuevoActor) {
        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setId(nuevoActor.getId());
        actorResponse.setNombre(nuevoActor.getNombre());
        actorResponse.setApellido(nuevoActor.getApellido());
        return actorResponse;
    }

}

