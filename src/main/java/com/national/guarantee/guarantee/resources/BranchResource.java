package com.national.guarantee.guarantee.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.national.guarantee.guarantee.entities.Branch;
import com.national.guarantee.guarantee.services.BranchService;

@RestController
@RequestMapping(value = "/branchs")
public class BranchResource {
	
	@Autowired
	private BranchService service; 
	
	
	
	@GetMapping
	public ResponseEntity<List<Branch>> findAll(){
		List<Branch> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<Branch> findById(@PathVariable Long id){
		Branch obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
