package com.example.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cine.models.ActorModel;

@Repository
public interface ActorRepository extends JpaRepository<ActorModel, Long> {
}
