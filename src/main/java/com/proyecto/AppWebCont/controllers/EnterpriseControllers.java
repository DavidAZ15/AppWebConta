package com.proyecto.AppWebCont.controllers;

import com.proyecto.AppWebCont.entities.Enterprise;
import com.proyecto.AppWebCont.services.EnterpriseServices;
import com.proyecto.AppWebCont.services.Response;
import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // como vasmos a recibir y generar datos de manera plana"json" lo vamos  a llamar servicios rest
@RequestMapping("enterprise") // genero con esta etiqueta el ruteo o la URL que va llevar este controlador
public class EnterpriseControllers {



    private EnterpriseServices enterpriseservice;
    public EnterpriseControllers(EnterpriseServices serEnterprise){
        this.enterpriseservice=serEnterprise;
    }
    //metodo para taer todos los datos de la tabla empresa
    @RequestMapping("get")
    public ArrayList<Enterprise> selectAll(){
        return this.enterpriseservice.selectAll();
    }
    //metodo para consultar una sola empresa
    @RequestMapping("get/enterprise/{id}")
    public Enterprise getenterprise(@PathVariable int id){
        return this.enterpriseservice.selectById(id);
    }
    //metodo para crear una empresa
    @PostMapping("create")
    private Response createenterprise(@RequestBody Enterprise newEnterprise){
        return this.enterpriseservice.createEnterprise(newEnterprise);
    }
    @DeleteMapping("delete/{id}")
    public Response deleteEnterprise(@PathVariable int id){
        return this.enterpriseservice.deleteEnterpriseById(id);
    }

}
