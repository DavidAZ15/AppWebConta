package com.proyecto.AppWebCont.repository;

import com.proyecto.AppWebCont.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
