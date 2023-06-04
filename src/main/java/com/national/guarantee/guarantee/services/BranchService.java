package com.national.guarantee.guarantee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.national.guarantee.guarantee.entities.Branch;
import com.national.guarantee.guarantee.repositories.BranchRepository;

@Service
public class BranchService {

	@Autowired
	private BranchRepository repository;
	
	public List<Branch> findAll(){
		return repository.findAll();
	}
	public Branch findById(Long id) {
		Optional<Branch> obj = repository.findById(id);
		return obj.get();
	}
}
