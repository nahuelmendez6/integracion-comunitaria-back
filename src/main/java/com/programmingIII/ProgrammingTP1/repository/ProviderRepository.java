package com.programmingIII.ProgrammingTP1.repository;

import com.programmingIII.ProgrammingTP1.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
