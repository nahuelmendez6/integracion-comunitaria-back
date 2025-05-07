package com.integracion_comunitaria.controller;

import com.integracion_comunitaria.model.Postulation;
import com.integracion_comunitaria.service.PostulationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/postulations")
public class PostulationController {

    @Autowired
    private PostulationService postulationService;

    // Obtener todas las postulaciones
    @GetMapping("/by-petition/{idPetition}")
    public List<Postulation> getByPetition(@PathVariable Long idPetition) {
        return postulationService.getByPetition(idPetition);
    }

    // Obtener solo una postulacion
    @GetMapping("/{id}")
    public Optional<Postulation> getPostulationByID(@PathVariable Long id) {
        return postulationService.getByID(id);
    }

    // Crear una nueva postulacion
    @PostMapping
    public Postulation createPostulation(@RequestBody Postulation postulation) {
        return postulationService.save(postulation);
    }

    // Eliminar una postulacion por ID
    @DeleteMapping("/{id}")
    public void deletePostulation(@PathVariable Long id) {
        postulationService.delete(id);
    }

    @PatchMapping("/{id}/winner")
    public ResponseEntity<String> updateWinner(@PathVariable Long id, @RequestBody String winner) {
        postulationService.updateWinner(id, winner);
        return ResponseEntity.ok("Campo 'winner' actualizado.");
    }

    @PatchMapping("/{id}/state")
    public ResponseEntity<String> updateIdState(@PathVariable Long id, @RequestBody Long idState) {
        postulationService.updateIdState(id, idState);
        return ResponseEntity.ok("Campo 'idState' actualizado.");
    }

    @PatchMapping("/{id}/current")
    public ResponseEntity<String> updateCurrent(@PathVariable Long id, @RequestBody String current) {
        postulationService.updateCurrent(id, current);
        return ResponseEntity.ok("Campo 'current' actualizado.");
    }


}
