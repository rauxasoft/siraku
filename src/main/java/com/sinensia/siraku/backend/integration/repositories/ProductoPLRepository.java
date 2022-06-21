package com.sinensia.siraku.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinensia.siraku.backend.integration.model.FamiliaPL;
import com.sinensia.siraku.backend.integration.model.ProductoPL;

@Repository
public interface ProductoPLRepository extends JpaRepository<ProductoPL, Long>{

	List<ProductoPL> findByFamilia(FamiliaPL familia);
	
}
