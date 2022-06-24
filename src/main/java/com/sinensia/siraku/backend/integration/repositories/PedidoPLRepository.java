package com.sinensia.siraku.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinensia.siraku.backend.integration.model.LineaPedidoPL;
import com.sinensia.siraku.backend.integration.model.PedidoPL;

@Repository
public interface PedidoPLRepository extends JpaRepository<PedidoPL, Long>{
	
	@Query("SELECT lip FROM PedidoPL p JOIN p.lineas lip")
	List<LineaPedidoPL> getLineasPedido();
	
	@Query("SELECT lip FROM PedidoPL p JOIN p.lineas lip WHERE p.codigo = :codigo")
	List<LineaPedidoPL> getLineasPedido(Long codigo);

}
