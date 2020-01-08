package com.codegym.repository.impl;

import com.codegym.model.Users;
import com.codegym.repository.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class UserRepositoryImpl implements IUserRepository {



    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Users> findAll() {

        List<Users> users = em.createNamedQuery("findAllUserst").getResultList();

        return users;

    }

    @Override
    public void add(Users users) {

        StoredProcedureQuery spAddUsers = em.createNamedStoredProcedureQuery("AddStoredProcedure");
        spAddUsers.setParameter("in_username", users.getName());
        spAddUsers.setParameter("in_useremail", users.getEmail());
        spAddUsers.setParameter("in_useraddress", users.getAddress());
        spAddUsers.setParameter("in_userdoB", users.getDoB());
        spAddUsers.setParameter("in_userphone", users.getPhone());
        spAddUsers.setParameter("in_userimg", users.getImg());
        spAddUsers.execute();
    }

    @Override
    public Users findById(long id) {
        Users users = (Users) em.createNamedQuery("findProductById")
                .setParameter("userId",id).getSingleResult();
        return users;
    }

    @Override
    public void remove(Long id) {
        StoredProcedureQuery spDeleteUsers = em.createNamedStoredProcedureQuery("deleteUserStoredProcedure");
        spDeleteUsers.setParameter("in_userId",id );
        spDeleteUsers.execute();
    }

    @Override
    public void editUsers(int id, Users users) {
        StoredProcedureQuery spAddUsers = em.createNamedStoredProcedureQuery("updateUsersStoredProcedure");
        spAddUsers.setParameter("in_userId",id);
        spAddUsers.setParameter("in_username", users.getName());
        spAddUsers.setParameter("in_useremail", users.getEmail());
        spAddUsers.setParameter("in_useraddress", users.getAddress());
        spAddUsers.setParameter("in_userdoB", users.getDoB());
        spAddUsers.setParameter("in_userphone", users.getPhone());
        spAddUsers.setParameter("in_userimg", users.getImg());
        spAddUsers.execute();
    }


}
