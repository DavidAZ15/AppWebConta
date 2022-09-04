package com.proyecto.AppWebCont.repository;


import com.proyecto.AppWebCont.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnterpriseRepository extends JpaRepository<Enterprise,Integer> {
}
