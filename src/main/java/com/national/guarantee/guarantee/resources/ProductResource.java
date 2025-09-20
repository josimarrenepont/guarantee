package com.national.guarantee.guarantee.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.national.guarantee.guarantee.entities.dto.ProductDTO;
import com.national.guarantee.guarantee.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.national.guarantee.guarantee.entities.Product;
import com.national.guarantee.guarantee.services.impl.ProductServiceImpl;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Product", description = "Endpoints para gerenciamento de products")
public class ProductResource {
	

	private final ProductService service;

	@Autowired
    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
	@Operation(summary = "Lista todas os products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna a lista de products com sucesso"),
	})
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<Product> list = service.findAll();
		List<ProductDTO> productDTOS = list.stream().map(ProductDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(productDTOS);
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca uma product por ID", description = "Retorna os detalhes de um product específica com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product encontrada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Product não encontrada")
	})
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		ProductDTO productDTO = new ProductDTO(obj);
		return ResponseEntity.ok().body(productDTO);
	}
	@PostMapping
	@Operation(summary = "Criar um product", description = "Criando um product.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product criado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Não foi possível criar um product")
	})
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
		Product createProduct = service.createProduct(productDTO);
		ProductDTO createdDTO = new ProductDTO(createProduct);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(createdDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(createdDTO);
	}
	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um product", description = "Atualizando um product com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product atualizado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Não foi possível atualizar o product")
	})
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO obj){
		Product product = service.update(id, obj);
		ProductDTO productDTO = new ProductDTO(product);
		return ResponseEntity.ok().body(productDTO);
	}
}