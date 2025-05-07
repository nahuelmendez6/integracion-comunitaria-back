package com.integracion_comunitaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.integracion_comunitaria.model.Postulation;

import jakarta.transaction.Transactional;

/**
 * Repositorio JPA para la entidad Postulation.
 * Proporciona métodos para acceder y modificar datos relacionados con postulaciones.
 */

@Transactional
public interface PostulationRepository extends JpaRepository<Postulation, Long> {


    /**
     * Obtiene una lista de postulaciones asociadas a una petición específica.
     *
     * @param idPetition ID de la petición.
     * @return Lista de postulaciones correspondientes.
     */

    List<Postulation> findByIdPetition(Long idPetition);

    


    boolean existsByIdPetitionAndIdProvider(Long idPetition, Long idProvider);
    
    @Modifying
    @Query("UPDATE Postulation p SET p.winner = :winner WHERE p.idPostulation = :id")
    void updateWinnerById(@Param("id") Long id, @Param("winner") String winner);

    @Modifying
    @Query("UPDATE Postulation p SET p.idState = :idState WHERE p.idPostulation = :id")
    void updateIdStateById(@Param("id") Long id, @Param("idState") Long idState);

    @Modifying
    @Query("UPDATE Postulation p SET p.current = :current WHERE p.idPostulation = :id")
    void updateCurrentById(@Param("id") Long id, @Param("current") String current);

}
