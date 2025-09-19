package com.national.guarantee.guarantee.services.impl;

import java.util.List;
import java.util.Optional;

import com.national.guarantee.guarantee.services.BranchService;
import com.national.guarantee.guarantee.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.national.guarantee.guarantee.entities.Branch;
import com.national.guarantee.guarantee.repositories.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {


	private final BranchRepository repository;

	public BranchServiceImpl (BranchRepository repository){
		this.repository = repository;
	}

	@Override
	public List<Branch> findAll(){
		return repository.findAll();
	}

	@Override
	public Branch findById(Long id) {
		Optional<Branch> obj = repository.findById(id);
				return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
