package com.example.cine.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaResponse {
    private Long id;
    private String titulo;
    private Long idActor;
    private String isbn;
}
