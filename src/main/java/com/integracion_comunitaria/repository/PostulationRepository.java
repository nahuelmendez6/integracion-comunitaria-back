package com.integracion_comunitaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.integracion_comunitaria.model.Postulation;


public interface PostulationRepository extends JpaRepository<Postulation, Long> {

    List<Postulation> findByPetition(Long idPetition);

}
