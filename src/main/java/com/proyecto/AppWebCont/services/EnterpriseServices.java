package com.proyecto.AppWebCont.services;


import com.proyecto.AppWebCont.entities.Enterprise;
import com.proyecto.AppWebCont.repository.IEnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EnterpriseServices {

    private IEnterpriseRepository enterpriseRepository;
    public EnterpriseServices(IEnterpriseRepository repEnterprise){

        this.enterpriseRepository=repEnterprise;
    }

    // creamos este metodo para traer todos los datos de la tabla empresas
    public ArrayList<Enterprise> selectAll(){

        return (ArrayList<Enterprise>) this.enterpriseRepository.findAll();
    }

    // creamos este metodo para traer los datos de una sola empresa
    public Enterprise selectById(int Id){
        Optional<Enterprise> existeEmpresa=this.enterpriseRepository.findById(Id);
        if(existeEmpresa.isPresent()){
            return existeEmpresa.get();
        }
        else{
            return null;
        }
    }
    //metodo para crear un registro en la tabla empresa
    public Response createEnterprise(Enterprise newData){
        Response response=new Response();
        this.enterpriseRepository.save(newData);
        response.setCode(200);
        response.setMessage("Empresa registrada existosamente");
        return response;
    }
    //acá se elimina una fila de la tabla empresa por el id
    public Response deleteEnterpriseById(int id){
        Response response= new Response();
        try{
            this.enterpriseRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("Empresa eliminada existosamente");
            return  response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error,"+ex.getMessage());
            return response;
        }
    }

    //metodo para editar o actualizar un dto de la tabla empresas
    public Response updateEnterprise(Enterprise updateNewEnterprise){
        Response response=new Response();
        Enterprise existEnterprise = selectById(updateNewEnterprise.getId());
        //primero es validar si el usuario existe en la tabla
        if (updateNewEnterprise.getId()==0 || existEnterprise==null){
            response.setCode(500);
            response.setMessage("Error, el Id de la empresa no es valido o no existe");
            return response;

        }
        existEnterprise.setDocument(updateNewEnterprise.getDocument());
        existEnterprise.setName(updateNewEnterprise.getName());
        existEnterprise.setAddress(updateNewEnterprise.getAddress());
        existEnterprise.setPhone(updateNewEnterprise.getPhone());
        this.enterpriseRepository.save(existEnterprise);
        response.setCode(200);
        response.setMessage("Datos modificados correctamente");
        return response;
    }


}
