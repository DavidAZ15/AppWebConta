package com.proyecto.AppWebCont.entities;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity//Para que se mapee como una base de datos
@Table(name="Empresas")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// acá estamos autogenerando el id de la tabla
    private int id;

    @Column(name = "Nombre")
    private String name;

    @Column(name = "Documento")
    private String document;

    @Column(name = "Telefono")
    private String phone;

    @Column(name = "direccion")
    private String address;

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

    public String getDocument() {

        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }















}
