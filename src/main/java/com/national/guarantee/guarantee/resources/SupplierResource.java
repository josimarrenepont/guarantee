package com.national.guarantee.guarantee.resources;

import java.util.List;

import com.national.guarantee.guarantee.services.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.national.guarantee.guarantee.entities.Supplier;
import com.national.guarantee.guarantee.services.impl.SupplierServiceImpl;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierResource {
	

	private final SupplierService service;

    public SupplierResource(SupplierService service) {
        this.service = service;
    }

    @GetMapping
	@Operation(summary = "Lista todas as supplier")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna a lista de suppliers com sucesso"),
	})
	public ResponseEntity<List<Supplier>> findAll() {
		List<Supplier> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca uma supplier por ID", description = "Retorna os detalhes de um supplier específica com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Supplier encontrada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Supplier não encontrada")
	})
	public ResponseEntity<Supplier> findById(@PathVariable Long id) {
		Supplier obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
