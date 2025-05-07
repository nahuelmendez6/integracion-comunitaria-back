package com.integracion_comunitaria.service;

import java.util.List;
import java.util.Optional;

import com.integracion_comunitaria.model.Postulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integracion_comunitaria.repository.PostulationRepository;

import jakarta.transaction.Transactional;

/**
 * Servicio que gestiona la lógica de negocio relacionada con las postulaciones.
 */
@Service
public class PostulationService {

    @Autowired
    private PostulationRepository repository;

    /**
     * Obtiene todas las postulaciones asociadas a una petición específica.
     *
     * @param idPetition ID de la petición.
     * @return Lista de postulaciones.
     */
    public List<Postulation> getByPetition(Long idPetition) {
        return repository.findByIdPetition(idPetition);
    }

    /**
     * Obtiene una postulación por su ID.
     *
     * @param id ID de la postulación.
     * @return Objeto Optional con la postulación si existe.
     */
    public Optional<Postulation> getByID(Long id) {
        return repository.findById(id);
    }

    /**
     * Guarda una nueva postulación, validando que no exista previamente una
     * del mismo proveedor para la misma petición.
     *
     * @param postulation Objeto de postulación a guardar.
     * @return La postulación guardada.
     * @throws IllegalArgumentException si ya existe una postulación duplicada.
     */
    public Postulation save(Postulation postulation) {

        boolean exists = repository.existsByIdPetitionAndIdProvider(
            postulation.getIdPetition(), postulation.getIdProvider()
        );

        boolean costIsPositive = repository.costIsPositive(postulation.getCost());

        if (exists) {
            throw new IllegalArgumentException("Ya existe una postulacion de este proveedor para esta peticion");
        } else if (!costIsPositive) {
            throw new IllegalArgumentException("El costo de la postulacion debe ser positivo");
        }

        return repository.save(postulation);
    }

    /**
     * Elimina una postulación por su ID.
     *
     * @param id ID de la postulación a eliminar.
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Transactional
    public void updateWinner(Long id, String winner) {
        repository.updateWinnerById(id, winner);
    }

    @Transactional
    public void updateIdState(Long id, Long idState) {
        repository.updateIdStateById(id, idState);
    }

    @Transactional
    public void updateCurrent(Long id, String current) {
        repository.updateCurrentById(id, current);
    }

}
