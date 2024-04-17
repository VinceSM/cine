package com.example.cine.models;

import org.springframework.stereotype.Component;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.lang.String;

@Entity
@Table(name = "actores")
@Getter
@Setter
@Component
public class ActorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @ManyToMany
    private List<PeliculaModel> peliculas;

}
