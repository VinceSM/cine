package com.example.cine.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaRequest {
    private String year;
    private String titulo;
    private Long idActor;
}
