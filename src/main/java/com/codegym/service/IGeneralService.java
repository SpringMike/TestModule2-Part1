package com.codegym.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();
    void add(E e);
    E findById(Long id);
    void remove(Long id);
    void editUsers(Long id,E e);
}

