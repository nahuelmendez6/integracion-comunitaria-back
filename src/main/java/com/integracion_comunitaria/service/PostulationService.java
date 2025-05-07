package com.integracion_comunitaria.service;

import java.util.List;
import java.util.Optional;

import com.integracion_comunitaria.model.Postulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integracion_comunitaria.repository.PostulationRepository;

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
        return repository.save(postulation);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
