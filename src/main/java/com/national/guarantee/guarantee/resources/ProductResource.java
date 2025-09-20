package com.national.guarantee.guarantee.resources;

import java.util.List;

import com.national.guarantee.guarantee.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.national.guarantee.guarantee.entities.Product;
import com.national.guarantee.guarantee.services.impl.ProductServiceImpl;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Branch", description = "Endpoints para gerenciamento de products")
public class ProductResource {
	

	private final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
	@Operation(summary = "Lista todas os products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna a lista de products com sucesso"),
	})
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca uma product por ID", description = "Retorna os detalhes de um product específica com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product encontrada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Product não encontrada")
	})
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}