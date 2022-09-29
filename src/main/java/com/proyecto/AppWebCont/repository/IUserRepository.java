package com.proyecto.AppWebCont.repository;

import java.util.ArrayList;

import com.proyecto.AppWebCont.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface IUserRepository extends JpaRepository<User, Integer> {


    @Query("SELECT u FROM User u WHERE u.Correo = ?1 and u.Contraseña = ?2")
    ArrayList<User> validaCredenciales(String usuario, String password);

    @Query("SELECT u FROM User u WHERE u.Correo = ?1")
    ArrayList<User> existeCorreo(String correoElectronico);
}