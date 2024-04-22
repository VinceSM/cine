package com.example.cine.models;

import org.springframework.stereotype.Component;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "peliculas")
@Component
public class PeliculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "year")
    private String year;

    @Column(name = "idActor")
    private Long idActor;

    @Column(name = "duracion")
    private String duracion;

}
