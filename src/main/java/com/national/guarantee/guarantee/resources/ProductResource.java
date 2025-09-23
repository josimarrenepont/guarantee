package com.national.guarantee.guarantee.resources;

import com.national.guarantee.guarantee.entities.dto.ProductDTO;
import com.national.guarantee.guarantee.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Product", description = "Endpoints para gerenciamento de products")
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
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Busca uma product por ID", description = "Retorna os detalhes de um product específico com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product encontrada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Product não encontrada")
	})
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
		ProductDTO productDTO = service.findById(id);
		return ResponseEntity.ok().body(productDTO);
	}

	@PostMapping
	@Operation(summary = "Criar um product", description = "Criando um product.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Product criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Não foi possível criar um product")
	})
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
		ProductDTO createdDTO = service.createProduct(productDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(createdDTO);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um product", description = "Atualizando um product com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product atualizado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Não foi possível atualizar o product")
	})
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO obj){
		ProductDTO productDTO = service.update(id, obj);
		return ResponseEntity.ok().body(productDTO);
	}
}
