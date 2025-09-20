package com.national.guarantee.guarantee.resources;

import java.util.List;

import com.national.guarantee.guarantee.services.OrderService;
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

import com.national.guarantee.guarantee.entities.Order;
import com.national.guarantee.guarantee.services.impl.OrderServiceImpl;

@RestController
@RequestMapping(value = "/orders")
@Tag(name = "Branch", description = "Endpoints para gerenciamento de orders")
public class OrderResource {

	private final OrderService service;

    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping
	@Operation(summary = "Lista todas as orders")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna a lista de orders com sucesso"),
	})
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
}
	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca uma order por ID", description = "Retorna os detalhes de uma order específica com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Order encontrada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Order não encontrada")
	})
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}