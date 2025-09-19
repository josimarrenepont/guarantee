package com.national.guarantee.guarantee.services;

import com.national.guarantee.guarantee.entities.Branch;

import java.util.List;

public interface BranchService {

    List<Branch> findAll();

    Branch findById(Long id);
}
