package com.sinensia.siraku.backend.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinensia.siraku.backend.integration.model.FamiliaPL;
import com.sinensia.siraku.backend.integration.model.ProductoPL;

@Repository
public interface ProductoPLRepository extends JpaRepository<ProductoPL, Long>{

	List<ProductoPL> findByFamilia(FamiliaPL familia);
	List<ProductoPL> findByPrecioBetween(double min, double max);
	List<ProductoPL> findByFechaAltaBetween(Date desde, Date hasta);
	
	@Query("SELECT p.familia, count(p) FROM ProductoPL p GROUP BY p.familia")
	List<Object[]> getEstadistica1();
	
	@Query("SELECT p.familia, AVG(p.precio) FROM ProductoPL p GROUP BY p.familia")
	List<Object[]> getEstadistica2();
}
