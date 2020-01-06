package com.codegym.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();
    void add(E e);
    E findById(int id);
    void remove(int id);
    void editUsers(int id,E e);
}

