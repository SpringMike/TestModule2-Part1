package com.codegym.repository;



import java.util.List;

public interface IGeneralRepository<E> {
    List<E> findAll();
    void add (E e);
    E findById(long id);
    void remove(Long id);
    void editUsers(int id,E e);

}
