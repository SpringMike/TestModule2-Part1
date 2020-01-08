package com.codegym.service.impl;

import com.codegym.model.Users;
import com.codegym.repository.IUsersSpringDataRepository;
import com.codegym.service.IUsersSpringDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersSpringDataServiceImpl implements IUsersSpringDataService {
    @Autowired
    IUsersSpringDataRepository usersSpringDataRepository;



    @Override
    public Iterable<Users> findAll() {
        return usersSpringDataRepository.findAll();
    }

    @Override
    public void save(Users users) {
        usersSpringDataRepository.save(users);
    }

    @Override
    public Users findById(Long id) {
        Users users = usersSpringDataRepository.findOne(id);
        return users;
    }

    @Override
    public void remove(Long id) {
        usersSpringDataRepository.delete(id);
    }

}
