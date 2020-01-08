package com.codegym.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();
    void add(E e);
    E findById(long id);
    void remove(Long id);
    void editUsers(int id,E e);
}

