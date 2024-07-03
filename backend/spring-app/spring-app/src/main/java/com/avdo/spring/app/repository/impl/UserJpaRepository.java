package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.UserRepository;
import com.avdo.spring.app.repository.crud.CrudUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserJpaRepository implements UserRepository {

    private final CrudUserRepository crudUserRepository;

    @Autowired
    public UserJpaRepository(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }
}
