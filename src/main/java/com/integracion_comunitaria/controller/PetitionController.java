package com.integracion_comunitaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.integracion_comunitaria.model.Petition;
import com.integracion_comunitaria.repository.PetitionRepository;

@RestController
@RequestMapping("/api/petitions")
public class PetitionController {
    
    @Autowired
    private PetitionRepository petitionRepository;

    @GetMapping
    public List<Petition> getAll() {
        return petitionRepository.findAll();
    }

}
