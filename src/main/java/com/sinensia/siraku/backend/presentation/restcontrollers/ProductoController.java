package com.sinensia.siraku.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.siraku.backend.business.model.Familia;
import com.sinensia.siraku.backend.business.model.Producto;
import com.sinensia.siraku.backend.business.services.ProductoServices;

@RestController
public class ProductoController {

	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/productos")
	public List<Producto> getProductos(@RequestParam (value="familia", required=false) Familia familia, 
			                           @RequestParam (value="min", required=false) Double precioMin, 
			                           @RequestParam (value="max", required=false) Double precioMax) {
		
		List<Producto> productos = null;
		
		if(familia == null && precioMin == null) {
			productos = productoServices.getAll();
		} else {
			if (familia !=null) {
				productos = productoServices.getByFamilia(familia);
			} else {
				productos = productoServices.getBetweenPriceRange(precioMin, precioMax);
			}
		}
		
		return productos;
	}
	
	@GetMapping("/productos/{codigo}")
	public Producto getByCodigo(@PathVariable Long codigo) {
		return productoServices.read(codigo);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> create(@RequestBody Producto producto, UriComponentsBuilder ucb){
		
		Producto createdProducto = productoServices.create(producto);
		
		return ResponseEntity
				.created(ucb.path("/productos/{codigo}").build(createdProducto.getCodigo()))
				.build();
	}
	
	@DeleteMapping("/productos/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Long codigo){
		
		boolean eliminado = productoServices.delete(codigo);
		
		if (eliminado) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // 204
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();   // 404
		}
		
	}

}
