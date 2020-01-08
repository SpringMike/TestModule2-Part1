package com.codegym.service;

public interface IGeneralSpringDataService<E> {
    Iterable<E> findAll();

    void save(E e);

    E findById(Long id);

    void remove(Long id);

}
