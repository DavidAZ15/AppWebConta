package com.proyecto.AppWebCont.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasControllers {

    @GetMapping("sgingresos")
    public String sgingresos(){
        return "movimientos/ingresosegresos";
    }

    @GetMapping("sgusuarios")
    public String sgusuarios(){
        return "usuarios/usuarios";
    }

    @GetMapping("sgempresas")
    public String sgempresas(){
        return "empresas/empresas";
    }

    @GetMapping("sgnuevousuario")
    public String sgnuevousuario(){
        return "usuarios/nuevousuario";
    }

    @GetMapping("sgnuevomovimiento")
    public String sgnuevomovimiento(){
        return "movimientos/Nuevoingreso";
    }

    @GetMapping("sgnuevaempresa")
    public String sgnuevaempresa(){
        return "empresas/nuevaempresa";
    }
}
