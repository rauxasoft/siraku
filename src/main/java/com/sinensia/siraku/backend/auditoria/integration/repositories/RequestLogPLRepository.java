package com.sinensia.siraku.backend.auditoria.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinensia.siraku.backend.auditoria.integration.model.RequestLogPL;

@Repository
public interface RequestLogPLRepository extends JpaRepository<RequestLogPL, Long>{

}
