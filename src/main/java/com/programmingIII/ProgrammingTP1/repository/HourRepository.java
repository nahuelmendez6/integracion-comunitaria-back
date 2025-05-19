package com.programmingIII.ProgrammingTP1.repository;

import com.programmingIII.ProgrammingTP1.model.Hour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourRepository extends JpaRepository<Hour, Integer> {
}
