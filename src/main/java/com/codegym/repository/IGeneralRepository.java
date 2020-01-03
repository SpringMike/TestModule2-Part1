package com.codegym.repository;



import java.util.List;

public interface IGeneralRepository<E> {
    List<E> findAll();
    void add (E e);
    E findById(Long id);
    void remove(Long id);
    void editUsers(Long id,E e);

}
