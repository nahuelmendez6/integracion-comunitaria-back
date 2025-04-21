package com.integracion_comunitaria.controller;

import com.integracion_comunitaria.model.Postulation;
import com.integracion_comunitaria.repository.PostulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/postulations")
public class PostulationController {

    @Autowired
    private PostulationRepository postulationRepository;

    // Obtener todas las postulaciones
    @GetMapping("/by-petition/{idPetition}")
    public List<Postulation> getByPetition(@PathVariable Long idPetition) {
        return postulationRepository.findByPetition(idPetition);
    }

    // Obtener solo una postulacion
    @GetMapping("/{id}")
    public Optional<Postulation> getPostulationByID(@PathVariable Long id) {
        return postulationRepository.findById(id);
    }


}
