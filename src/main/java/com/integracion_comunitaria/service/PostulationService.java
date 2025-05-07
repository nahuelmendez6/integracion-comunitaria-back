package com.integracion_comunitaria.service;

import java.util.List;
import java.util.Optional;

import com.integracion_comunitaria.model.Postulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integracion_comunitaria.repository.PostulationRepository;

import jakarta.transaction.Transactional;

@Service
public class PostulationService {

    @Autowired
    private PostulationRepository repository;

    public List<Postulation> getByPetition(Long idPetition) {
        return repository.findByIdPetition(idPetition);
    }

    public Optional<Postulation> getByID(Long id) {
        return repository.findById(id);
    }

    public Postulation save(Postulation postulation) {

        boolean exists = repository.existsByIdPetitionAndIdProvider(
            postulation.getIdPetition(), postulation.getIdProvider()    
        );

        if (exists) {
            throw new IllegalArgumentException("Ya existe una postulacion de este proveedor para esta peticion");
        }

        return repository.save(postulation);
    }

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
