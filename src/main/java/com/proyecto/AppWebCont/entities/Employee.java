package com.proyecto.AppWebCont.entities;


import javax.persistence.*;

@Entity
@Table(name = "Empleados")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Correo")
    private String email;

    @Column(name = "Rol")
    private EnumRoleName role;






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
