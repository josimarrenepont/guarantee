package com.national.guarantee.guarantee.services.impl;

import java.util.List;
import java.util.Optional;

import com.national.guarantee.guarantee.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.national.guarantee.guarantee.entities.User;
import com.national.guarantee.guarantee.repositories.UserRepository;
import com.national.guarantee.guarantee.services.exceptions.DatabaseException;
import com.national.guarantee.guarantee.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	

	private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

	@Override
    public List<User> findAll(){
		return repository.findAll();
	}

	@Override
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	@Override
	public User insert(User obj) {
		return repository.save(obj);
	}

	@Override
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setDescriptionCompany(obj.getDescriptionCompany());
	}
}
