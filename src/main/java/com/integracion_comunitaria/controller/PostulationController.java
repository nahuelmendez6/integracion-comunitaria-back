package com.integracion_comunitaria.controller;

import com.integracion_comunitaria.model.Postulation;
import com.integracion_comunitaria.service.PostulationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


/**
 * Controlador REST para gestionar las postulaciones.
 * Proporciona endpoints para crear, obtener, eliminar y actualizar campos específicos de las postulaciones.
 */

@RestController
@RequestMapping("/api/postulations")
public class PostulationController {

    @Autowired
    private PostulationService postulationService;

    
    /**
     * Obtiene todas las postulaciones asociadas a una petición específica.
     *
     * @param idPetition ID de la petición.
     * @return Lista de postulaciones correspondientes.
     */
    @GetMapping("/by-petition/{idPetition}")
    public List<Postulation> getByPetition(@PathVariable Long idPetition) {
        return postulationService.getByPetition(idPetition);
    }

    /**
     * Obtiene una postulación por su ID.
     *
     * @param id ID de la postulación.
     * @return Objeto Postulation si existe, o vacío si no se encuentra.
     */
    @GetMapping("/{id}")
    public Optional<Postulation> getPostulationByID(@PathVariable Long id) {
        return postulationService.getByID(id);
    }

     /**
     * Crea una nueva postulación.
     *
     * @param postulation Objeto Postulation recibido en el cuerpo de la solicitud.
     * @return La postulación guardada.
     */
    @PostMapping
    public Postulation createPostulation(@RequestBody Postulation postulation) {
        return postulationService.save(postulation);
    }

     /**
     * Elimina una postulación por su ID.
     *
     * @param id ID de la postulación a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deletePostulation(@PathVariable Long id) {
        postulationService.delete(id);
    }

     /**
     * Actualiza el campo 'winner' de una postulación específica.
     *
     * @param id     ID de la postulación.
     * @param winner Nuevo valor del campo 'winner'.
     * @return Mensaje de éxito.
     */
    @PatchMapping("/{id}/winner")
    public ResponseEntity<String> updateWinner(@PathVariable Long id, @RequestBody String winner) {
        postulationService.updateWinner(id, winner);
        return ResponseEntity.ok("Campo 'winner' actualizado.");
    }

     /**
     * Actualiza el campo 'idState' de una postulación específica.
     *
     * @param id      ID de la postulación.
     * @param idState Nuevo valor del campo 'idState'.
     * @return Mensaje de éxito.
     */
    @PatchMapping("/{id}/state")
    public ResponseEntity<String> updateIdState(@PathVariable Long id, @RequestBody Long idState) {
        postulationService.updateIdState(id, idState);
        return ResponseEntity.ok("Campo 'idState' actualizado.");
    }

     /**
     * Actualiza el campo 'current' de una postulación específica.
     *
     * @param id      ID de la postulación.
     * @param current Nuevo valor del campo 'current'.
     * @return Mensaje de éxito.
     */

    @PatchMapping("/{id}/current")
    public ResponseEntity<String> updateCurrent(@PathVariable Long id, @RequestBody String current) {
        postulationService.updateCurrent(id, current);
        return ResponseEntity.ok("Campo 'current' actualizado.");
    }


}
