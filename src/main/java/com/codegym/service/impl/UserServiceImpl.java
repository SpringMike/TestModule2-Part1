package com.codegym.service.impl;

import com.codegym.model.Users;
import com.codegym.model.UsersForm;
import com.codegym.repository.IUserRepository;
import com.codegym.repository.impl.UserRepositoryImpl;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void add(Users users) {
        userRepository.add(users);
    }

    @Override
    public Users findById(Long id) {
        Users users = userRepository.findById(id);
        return users;
    }

    @Override
    public void remove(Long id) {
        userRepository.remove(id);

    }

    @Override
    public void editUsers(Long id, Users users) {
        userRepository.editUsers(id, users);

    }
}

