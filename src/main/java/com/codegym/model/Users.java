package com.codegym.model;


import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.util.Date;


@Entity

@Table(name = "Users")

@NamedQuery( name="findAllUserst",
        query="select u from Users u")


@NamedQuery( name="findProductById",
        query="select u from Users u where u.id=:userId")

@NamedStoredProcedureQuery(
        name = "deleteUserStoredProcedure",
        procedureName = "deleteUsers",
        parameters = {
                @StoredProcedureParameter(name = "in_userId", mode = ParameterMode.IN, type = Integer.class),
        }
)

@NamedStoredProcedureQuery(
        name = "AddStoredProcedure",
        procedureName = "addProduct",
        parameters = {
                @StoredProcedureParameter(name = "in_username", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_useremail", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_useraddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_userdoB", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_userphone", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_userimg", mode = ParameterMode.IN, type = String.class),
        }
)

@NamedStoredProcedureQuery(
        name = "updateUsersStoredProcedure",
        procedureName = "editUsers",
        parameters = {
                @StoredProcedureParameter(name = "in_userId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "in_username", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_useremail", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_useraddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_userdoB", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_userphone", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_userimg", mode = ParameterMode.IN, type = String.class),

        }
)





public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;


    private String name;

    private String email;
    private String address;
    private String doB;
    private String phone;
    private String img;


    public Users(String name, String email, String address, String doB, String phone, String img) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.doB = doB;
        this.phone = phone;
        this.img = img;
    }

    public Users() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}