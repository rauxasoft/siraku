package com.sinensia.siraku.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinensia.siraku.backend.business.model.dtos.ClienteDTO1;
import com.sinensia.siraku.backend.integration.model.ClientePL;

@Repository
public interface ClientePLRepository extends JpaRepository<ClientePL, String>{

	// Consultas basadas en nombres de Spring Data
	
	List<ClientePL> findByDireccionPoblacion(String poblacion);
	List<ClientePL> findByDireccionCodigoPostal(String codigoPostal);
	List<ClientePL> findByNombre(String nombre);
	List<ClientePL> findByNombreLikeIgnoreCaseAndDireccionPoblacionOrderByIdentificadorFiscalDesc(String nombre, String poblacion);   // %mo%
	
	// Consultas con JPQL
	
	@Query("SELECT c FROM ClientePL c WHERE c.nombre = :nombre") 
	List<ClientePL> buscamePorNombre(String nombre);
	
	@Query("SELECT c "
		 + "FROM ClientePL c "
		 + "WHERE UPPER(c.nombre) LIKE UPPER(CONCAT('%',:nombre,'%')) "
		 + "AND c.direccion.poblacion = :poblacion "
		 + "ORDER BY c.identificadorFiscal DESC")
	List<ClientePL> findByNombreAndDireccionLike(String nombre, String poblacion);
	
	// No se devuelve una Entity. Se devuelven "cosas sueltas"
	
	@Query("SELECT CONCAT(c.identificadorFiscal,' - ',UPPER(c.nombre)), "
		 + "CONCAT(c.direccion.poblacion,' - ',c.direccion.codigoPostal,' (',c.direccion.pais,')') "
		 + "FROM ClientePL c")
	List<Object[]> dameCosas();
	
	// Pedemos devolver DTOs que se instancian (se requiere un método constructor)
	
	@Query("SELECT new com.sinensia.siraku.backend.business.model.dtos.ClienteDTO1(c.nombreComercial, "
		 + " UPPER(CONCAT (c.apellido2,' ',c.apellido1,', ',c.nombre))) "
		 + "FROM ClientePL c")
	List<ClienteDTO1> findClienteDTO1();
	
	@Query("SELECT c.identificadorFiscal, "
		 + "       c.nombreComercial, "
		 + "       c.nombre, "
		 + "       c.apellido1, "
		 + "       c.apellido2 "
		 + "FROM ClientePL c")
	List<Object[]> findDataForDTO2();
	
}
