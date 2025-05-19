package com.programmingIII.ProgrammingTP1.repository;

import com.programmingIII.ProgrammingTP1.model.Week;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRepository extends JpaRepository<Week, Integer> {
}
