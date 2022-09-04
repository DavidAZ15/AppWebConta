package com.proyecto.AppWebCont.services;

import com.proyecto.AppWebCont.entities.Employee;
import com.proyecto.AppWebCont.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeServices {

    private IEmployeeRepository employeeRepository;

    public EmployeeServices(IEmployeeRepository repEmployee){
        this.employeeRepository=repEmployee;
    }

    // creamos este metodo para traer todos los datos de la tabla empleados
    public ArrayList<Employee> selectAll(){
        return (ArrayList<Employee>) this.employeeRepository.findAll();
    }

    public Employee selectById(int Id){
        Optional<Employee> existeEmpleado=this.employeeRepository.findById(Id);
        if(existeEmpleado.isPresent()){
            return existeEmpleado.get();
        }
        else{
            return null;
        }
    }
    //metodo para crear un registro en la tabla empresa
    public Response createEmployee(Employee newData){
        Response response=new Response();
        this.employeeRepository.save(newData);
        response.setCode(200);
        response.setMessage("usuario registrado existosamente");
        return response;
    }
    //acá se elimina una fila de la tabla empresa por el id
    public Response deleteEmployeeById(int id){
        Response response= new Response();
        try{
            this.employeeRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("usuario eliminado existosamente");
            return  response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error,"+ex.getMessage());
            return response;
        }
    }

    //metodo para editar o actualizar un dto de la tabla empresas
    public Response updateEmployee(Employee updateNewEmployee){
        Response response=new Response();
        Employee existEmployee = selectById(updateNewEmployee.getId());
        //primero es validar si el usuario existe en la tabla
        if (updateNewEmployee.getId()==0 || existEmployee==null){
            response.setCode(500);
            response.setMessage("Error, el Id del empleado no es valido o no existe");
            return response;

        }
        existEmployee.setEmail(updateNewEmployee.getEmail());
        existEmployee.setEmail(updateNewEmployee.getEmail());
        this.employeeRepository.save(existEmployee);
        response.setCode(200);
        response.setMessage("Datos modificados correctamente");
        return response;
    }
}
