package com.java.service.impl;

import com.java.commons.GenericServiceImpl;
import com.java.dao.UserRepository;
import com.java.model.User;

import com.java.service.api.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserServiceAPI {

   @Autowired
    private UserRepository userRepository;

    @Override
    public CrudRepository<User, String> getDao() {
        return userRepository;
    }
}
