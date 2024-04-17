package com.example.cine.repositories;

import com.example.cine.models.PeliculaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaModel, Long> {
}
