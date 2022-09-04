package com.proyecto.AppWebCont.controllers;

import com.proyecto.AppWebCont.entities.Employee;
import com.proyecto.AppWebCont.services.EmployeeServices;
import com.proyecto.AppWebCont.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("employee")
public class EmployeeControllers {

    private EmployeeServices employeeservices;

    public EmployeeControllers(EmployeeServices serEmployee){
        this.employeeservices=serEmployee;
    }

    @RequestMapping("get")
    public ArrayList<Employee> selectAll(){
        return this.employeeservices.selectAll();
    }

    @RequestMapping("get/{id}")
    public Employee getEmployee(@PathVariable int id){
        return this.employeeservices.selectById(id);
    }
    //controlador para crear una empleado
    @PostMapping("create")
    private Response createEmployee(@RequestBody Employee newEmployee){
        return this.employeeservices.createEmployee(newEmployee);
    }
    @DeleteMapping("delete/{id}")
    public Response deleteEmployee(@PathVariable int id){
        return this.employeeservices.deleteEmployeeById(id);
    }

    @PutMapping("update")
    public Response updateEmployee(@RequestBody Employee updateNewEmployee){
        return this.employeeservices.updateEmployee(updateNewEmployee);
    }

}
