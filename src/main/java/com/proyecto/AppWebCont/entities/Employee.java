package com.proyecto.AppWebCont.entities;


import javax.persistence.*;

@Entity
@Table(name = "Empleados")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Correo")
    private String email;

    @Column(name = "Rol")
    private EnumRoleName role;

    //@Column(name = "Perfil")
    //private Profile profile;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}