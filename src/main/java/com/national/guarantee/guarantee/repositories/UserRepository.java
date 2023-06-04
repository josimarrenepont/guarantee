package com.national.guarantee.guarantee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.national.guarantee.guarantee.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
