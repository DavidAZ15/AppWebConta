package com.proyecto.AppWebCont.controllers;

import com.proyecto.AppWebCont.entities.Enterprise;
import com.proyecto.AppWebCont.entities.Transaction;
import com.proyecto.AppWebCont.services.Response;
import com.proyecto.AppWebCont.services.TransactionServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("movements")
public class TransactionControllers {

    private TransactionServices transactionservices;
    public TransactionControllers(TransactionServices serTransaction){
        this.transactionservices=serTransaction;
    }
    //creamos el control para traer todos los datos de la tabla de transaciones
    @RequestMapping("get")
    public ArrayList<Transaction> selectAll(){
        return this.transactionservices.selectAll();
    }

    @RequestMapping("{id}")
    public Transaction gerTransaction(@PathVariable int id){
        return this.transactionservices.selectById(id);
    }

    @PostMapping("create")
    private Response createTransaction(@RequestBody Transaction newTransaction){
        return this.transactionservices.createTransaction(newTransaction);
    }

    @DeleteMapping("delete/{id}")
    public Response deleteTransaction(@PathVariable int id){
        return this.transactionservices.deleteTransactionById(id);
    }
}
