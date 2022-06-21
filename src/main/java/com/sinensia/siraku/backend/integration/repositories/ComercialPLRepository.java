package com.sinensia.siraku.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinensia.siraku.backend.integration.model.ComercialPL;

@Repository
public interface ComercialPLRepository extends JpaRepository<ComercialPL, Long>{

}
