package com.national.guarantee.guarantee.services;

import com.national.guarantee.guarantee.entities.User;
import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User insert(User obj);

    void delete(Long id);

    User update(Long id, User obj);
}
