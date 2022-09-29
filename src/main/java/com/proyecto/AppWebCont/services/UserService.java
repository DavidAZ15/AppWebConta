package com.proyecto.AppWebCont.services;


import com.proyecto.AppWebCont.entities.User;
import com.proyecto.AppWebCont.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository repUser) {
        this.userRepository = repUser;
    }

    public Response creaUsuario(User nuevoUsuario) {
        Response response = new Response();
        ArrayList<User> existe = this.userRepository.existeCorreo(nuevoUsuario.getCorreo());
        if (existe != null && existe.size() > 0) {
            response.setCode(500);
            response.setMessage("Lamentablemente el correo ya esta en uso");
            return response;
        }
        return response;
    }
}