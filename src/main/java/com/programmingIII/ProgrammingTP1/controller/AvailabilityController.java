package com.programmingIII.ProgrammingTP1.controller;

import com.programmingIII.ProgrammingTP1.dto.AvailabilityDTO;
import com.programmingIII.ProgrammingTP1.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    /**
     * Obtener todas las disponibilidades de la base de datos.
     * @return una lista de objetos DTOs
     */
    @GetMapping
    public List<AvailabilityDTO> getAllAvailability(){
        return availabilityService.getAllAvailabilities();
    }

    /**
     * Obtener una disponibilidad mediante un ID.
     * @param idAvailability por el cual se va a buscar la disponibilidad.
     * @return un objeto DTO con los datos encontrados.
     * Lanza un ResourceNotFoundException(404) si la disponibilidad no se encuentra.
     */
    @GetMapping("/{idAvailability}")
    public AvailabilityDTO getAvailabilityById(@PathVariable int idAvailability){
        return availabilityService.getAvailabilityById(idAvailability);
    }

    /**
     * Crear un objeto Availability
     * @param availabilityDTO el objeto a crear.
     * @return un objeto DTO con los datos del objeto creado.
     * Lanza un ResourceNotFoundException(404) si hay algún parámetro que no se encontró (id_from_hour, id_until_hour, etc)
     */
    @PostMapping
    public AvailabilityDTO postAvailability(@RequestBody AvailabilityDTO availabilityDTO){
        return availabilityService.postAvailability(availabilityDTO);
    }

    /**
     * Actualizar completamente un objeto Availability
     * @param id identificardor para filtrar
     * @param availabilityDTO datos en formato json para actualizar
     * @return un objeto DTO actualizado
     * Lanza un ResourceNotFounException(404) si no se encuentra el identicador o los parámetros dados.
     */
    @PutMapping("/{id}")
    public AvailabilityDTO putAvailability(@PathVariable Integer id, @RequestBody AvailabilityDTO availabilityDTO){
        return availabilityService.putAvailability(id, availabilityDTO);
    }

    /**
     * Actualizar completamente un objeto Availability
     * @param id identificardor para filtrar
     * @param availabilityDTO datos en formato json para actualizar
     * @return un objeto DTO actualizado
     * Lanza un ResourceNotFounException(404) si no se encuentra el identicador o los parámetros dados.
     */
    @PatchMapping("/{id}")
    public AvailabilityDTO patchAvailability(@PathVariable Integer id, @RequestBody AvailabilityDTO availabilityDTO) {
        return availabilityService.patchAvailability(id, availabilityDTO);
    }

    /**
     * Eliminar un objeto Availability.
     * @param id para filtrar el objeto a eliminar.
     * @return un 204 indicando que se eliminó el objeto de manera correcta.
     * Lanza un ResourceNotFoundException(404) si hay no se encontró el objeto a eliminar.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable int id){
        availabilityService.deleteAvailability(id);
        return ResponseEntity.noContent().build(); // 204 sin contenido
    }

    /**
     * Buscar los objetos Availability que tiene cada Provider
     * @param idProvider identificador por el cual va a filtrar
     * @return una lista de AvailabilityDTO
     * Lanza un ResourceNotFoundException(404) si no se encontró el identificador del proveedor
     */
    @GetMapping("/provider/{idProvider}")
    public List<AvailabilityDTO> getAvailabilityByIdProvider(@PathVariable int idProvider){
        return availabilityService.findAvailabilityByProvider(idProvider);
    }
}
