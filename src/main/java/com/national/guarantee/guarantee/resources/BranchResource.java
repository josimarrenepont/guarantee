package com.national.guarantee.guarantee.resources;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.national.guarantee.guarantee.entities.Branch;

@RestController
@RequestMapping (value = "/branchs")
public class BranchResource {
	
	@GetMapping
	public ResponseEntity<Branch> findAll(){
		Branch branch = new Branch(null, 1, 123456, 5, new Date(), 12345, "erro");
		
		return ResponseEntity.ok().body(branch);
	}

}
