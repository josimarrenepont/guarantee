package com.national.guarantee.guarantee.resources;

import java.util.List;

import com.national.guarantee.guarantee.services.BranchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.national.guarantee.guarantee.entities.Branch;

@RestController
@RequestMapping(value = "/branchs")
@Tag(name = "Branch", description = "Endpoints para gerenciamento de filiais")
public class BranchResource {


	private final BranchService service;

    public BranchResource(BranchService service) {
        this.service = service;
    }

	@GetMapping
	@Operation(summary = "Lista todas as filiais")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna a lista de filiais com sucesso"),
	})
	public ResponseEntity<List<Branch>> findAll(){
		List<Branch> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca uma filial por ID", description = "Retorna os detalhes de uma filial específica com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Filial encontrada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Filial não encontrada")
	})
	public ResponseEntity<Branch> findById(@PathVariable Long id){
		Branch obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
