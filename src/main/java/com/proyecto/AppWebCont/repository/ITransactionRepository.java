package com.proyecto.AppWebCont.repository;

import com.proyecto.AppWebCont.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {
}
