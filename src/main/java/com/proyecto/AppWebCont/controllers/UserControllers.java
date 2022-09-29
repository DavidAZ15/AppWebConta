package com.proyecto.AppWebCont.controllers;


import com.proyecto.AppWebCont.entities.User;
import com.proyecto.AppWebCont.services.Response;
import com.proyecto.AppWebCont.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserControllers {
    private UserService userService;
    public UserControllers(UserService serviUsuario){
        this.userService = serviUsuario;
    }
    @PostMapping("crear")
    public Response creaUser(@RequestBody User nuevoUsurio){
        return this.userService.creaUsuario(nuevoUsurio);
    }

}