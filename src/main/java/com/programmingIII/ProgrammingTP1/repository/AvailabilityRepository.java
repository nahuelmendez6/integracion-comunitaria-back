package com.programmingIII.ProgrammingTP1.repository;

import com.programmingIII.ProgrammingTP1.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {

    @Query("SELECT a FROM Availability a " +
            "JOIN FETCH a.provider " +
            "JOIN FETCH a.week " +
            "JOIN FETCH a.fromHour " +
            "JOIN FETCH a.untilHour " +
            "WHERE a.idAvailability = :id")
    Optional<Availability> findByIdWithDetails(@Param("id") int id);

    @Query("SELECT a FROM Availability a " +
            "JOIN FETCH a.provider " +
            "JOIN FETCH a.week " +
            "JOIN FETCH a.fromHour " +
            "JOIN FETCH a.untilHour")
    List<Availability> findByWithDetailsAll();

    @Query("SELECT a FROM Availability a " +
            "JOIN FETCH a.fromHour " +
            "JOIN FETCH a.untilHour " +
            "JOIN FETCH a.week " +
            "WHERE a.provider.id = :idProvider")
    List<Availability> findByIdProvider(@Param("idProvider") int idProvider);

}
