package com.integracion_comunitaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integracion_comunitaria.model.Petition;

public interface PetitionRepository extends JpaRepository<Petition, Integer> {

}