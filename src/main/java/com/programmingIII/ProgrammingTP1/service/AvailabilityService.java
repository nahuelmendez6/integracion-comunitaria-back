package com.programmingIII.ProgrammingTP1.service;

import com.programmingIII.ProgrammingTP1.exception.ResourceNotFoundException;
import com.programmingIII.ProgrammingTP1.model.Availability;
import com.programmingIII.ProgrammingTP1.repository.AvailabilityRepository;
import com.programmingIII.ProgrammingTP1.repository.HourRepository;
import com.programmingIII.ProgrammingTP1.repository.ProviderRepository;
import com.programmingIII.ProgrammingTP1.repository.WeekRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.programmingIII.ProgrammingTP1.dto.AvailabilityDTO;
import  com.programmingIII.ProgrammingTP1.model.*;

import java.util.List;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;
    @Autowired
    private HourRepository hourRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private WeekRepository weekRepository;

    /**
     * Obtener una disponibilidad mediante un ID.
     * @param id parámetro por el cual se va a filtrar la búsqueda.
     * @return un objeto DTO con los datos de la disponibilidad encontrada.
     */
    public AvailabilityDTO getAvailabilityById(int id) {
        Availability availability = availabilityRepository.findByIdWithDetails(id)
                .filter(a -> a.getProvider() != null && a.getWeek() != null && a.getFromHour() != null && a.getUntilHour() != null)
                .orElseThrow(() -> new ResourceNotFoundException("Availability with ID " + id + " not found"));
        return convertToDTO(availability);
    }

    /**
     * Obtener todas las disponibilidades en la base de datos.
     * @return un DTO con los datos de las disponibilidades encontradas.
     */
    public List<AvailabilityDTO> getAllAvailabilities() {
        return availabilityRepository.findByWithDetailsAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    /**
     * Crear una disponibilidad.
     * @param dto un objeto DTO en el cual tenemos todos los datos para crear el objeto.
     * @return un objeto DTO con el objeto creado.
     */
    public AvailabilityDTO postAvailability(AvailabilityDTO dto) {
        Availability availability = new Availability();

        Hour fromHour = hourRepository.findById(dto.getFromHour().getIdHour())
                .orElseThrow(() -> new RuntimeException("Hora FROM no encontrada"));

        Hour untilHour = hourRepository.findById(dto.getUntilHour().getIdHour())
                .orElseThrow(() -> new RuntimeException("Hora UNTIL no encontrada"));

        Week week = weekRepository.findById(dto.getWeek().getIdWeek())
                .orElseThrow(() -> new RuntimeException("Semana no encontrada"));

        Provider provider = providerRepository.findById(dto.getProvider().getIdProvider())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        availability.setFromHour(fromHour);
        availability.setUntilHour(untilHour);
        availability.setWeek(week);
        availability.setProvider(provider);

        Availability saved = availabilityRepository.save(availability);
        return convertToDTO(saved);
    }


    /**
     * Actualizar toda una disponibilidad.
     * @param id por el cual se va a filtrar la disponibilidad que se va a modificar.
     * @param availabilityDTO un objeto DTO con los datos a actualizar.
     * @return un objeto DTO con los datos actualizados.
     */
    public AvailabilityDTO putAvailability(int id, AvailabilityDTO availabilityDTO){
        Availability existing = availabilityRepository.findByIdWithDetails(id)
                .orElseThrow(()-> new ResourceNotFoundException("Availability with id: "+id+ " not found"));

        Hour fromHour = hourRepository.findById(availabilityDTO.getFromHour().getIdHour())
                .orElseThrow(() -> new ResourceNotFoundException("Hora con el ID: "+availabilityDTO.getFromHour().getIdHour() +" no encontrada"));

        Hour untilHour = hourRepository.findById(availabilityDTO.getUntilHour().getIdHour())
                .orElseThrow(()-> new ResourceNotFoundException("Hour until with id: " +availabilityDTO.getUntilHour().getIdHour() + " not found"));

        Week week = weekRepository.findById(availabilityDTO.getWeek().getIdWeek())
                .orElseThrow(() -> new ResourceNotFoundException("Week with id: " +availabilityDTO.getWeek().getIdWeek() +" not found"));

        Provider provider = providerRepository.findById(availabilityDTO.getProvider().getIdProvider())
                .orElseThrow(() -> new ResourceNotFoundException("Provider with id: "+availabilityDTO.getProvider().getIdProvider() +" not found"));

        existing.setFromHour(fromHour);
        existing.setUntilHour(untilHour);
        existing.setWeek(week);
        existing.setProvider(provider);

        availabilityRepository.save(existing);
        return convertToDTO(existing);
    }

    /**
     * Actualizar parcialmente una disponibilidad.
     * @param id por el cual se va a filtrar la disponibilidad que se va a modificar.
     * @param availabilityDTO un objeto dto con los datos a actualizar.
     * @return un objeto dto con los datos actualizados.
     */
    public AvailabilityDTO patchAvailability(int id, AvailabilityDTO availabilityDTO) {
        Availability availability = availabilityRepository.findByIdWithDetails(id)
                .orElseThrow(() -> new ResourceNotFoundException("Availability not found"));

        if (availabilityDTO.getFromHour() != null && availabilityDTO.getFromHour().getIdHour() != null) {
            Hour fromHour = hourRepository.findById(availabilityDTO.getFromHour().getIdHour())
                    .orElseThrow(() -> new ResourceNotFoundException("FromHour not found"));
            availability.setFromHour(fromHour);
        }

        if (availabilityDTO.getUntilHour() != null && availabilityDTO.getUntilHour().getIdHour() != null) {
            Hour untilHour = hourRepository.findById(availabilityDTO.getUntilHour().getIdHour())
                    .orElseThrow(() -> new ResourceNotFoundException("UntilHour not found"));
            availability.setUntilHour(untilHour);
        }

        if (availabilityDTO.getWeek() != null && availabilityDTO.getWeek().getIdWeek() != null) {
            Week week = weekRepository.findById(availabilityDTO.getWeek().getIdWeek())
                    .orElseThrow(() -> new ResourceNotFoundException("Week not found"));
            availability.setWeek(week);
        }

        if (availabilityDTO.getProvider() != null && availabilityDTO.getProvider().getIdProvider() != null) {
            Provider provider = providerRepository.findById(availabilityDTO.getProvider().getIdProvider())
                    .orElseThrow(() -> new ResourceNotFoundException("Provider not found"));
            availability.setProvider(provider);
        }

        availabilityRepository.save(availability);
        return convertToDTO(availability);
    }


    /**
     * Eliminar una disponibilidad desde la base de datos
     * @param id por el cual se va a filtrar la disponibilidad a eliminar.
     */
    public void deleteAvailability(int id){
        Availability availability = availabilityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Availability not found with id: " + id));
        availabilityRepository.delete(availability);
    }

    /**
     * Buscar disponibilidad mediante proveedores
     * @param idProvider identificador por el cual vamos a buscar
     * @return una lista de DTOs con los objetos availability encontrados
     */
    public List<AvailabilityDTO> findAvailabilityByProvider(int idProvider){
        Provider provider = providerRepository.findById(idProvider)
                .orElseThrow(() -> new ResourceNotFoundException("Provider with id: "+idProvider +" not found"));

        return availabilityRepository.findByIdProvider(idProvider)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    /**
     * Convertir un objeto Availability a un objeto DTO.
     * @param availability el objeto Availability a convertir.
     * @return el objeto DTO.
     */
    private AvailabilityDTO convertToDTO(Availability availability) {
        if (availability == null) return null;

        AvailabilityDTO dto = new AvailabilityDTO();
        dto.setIdAvailability(availability.getIdAvailability());

        // FROM HOUR
        if (availability.getFromHour() != null) {
            AvailabilityDTO.HourDTO hourDto = new AvailabilityDTO.HourDTO();
            hourDto.setIdHour(availability.getFromHour().getIdHour());
            hourDto.setName(availability.getFromHour().getName());
            dto.setFromHour(hourDto);
        }

        // UNTIL HOUR
        if (availability.getUntilHour() != null) {
            AvailabilityDTO.HourDTO hourDto = new AvailabilityDTO.HourDTO();
            hourDto.setIdHour(availability.getUntilHour().getIdHour());
            hourDto.setName(availability.getUntilHour().getName());
            dto.setUntilHour(hourDto);
        }

        // WEEK
        if (availability.getWeek() != null) {
            AvailabilityDTO.WeekDTO weekDto = new AvailabilityDTO.WeekDTO();
            weekDto.setIdWeek(availability.getWeek().getIdWeek());
            weekDto.setName(availability.getWeek().getName());
            dto.setWeek(weekDto);
        }

        // PROVIDER
        if (availability.getProvider() != null) {
            AvailabilityDTO.ProviderDTO providerDto = new AvailabilityDTO.ProviderDTO();
            providerDto.setIdProvider(availability.getProvider().getIdProvider());
            providerDto.setName(availability.getProvider().getName());
            dto.setProvider(providerDto);
        }

        return dto;
    }


}
