package com.proyecto.AppWebCont.services;

import com.proyecto.AppWebCont.entities.Enterprise;
import com.proyecto.AppWebCont.entities.Transaction;
import com.proyecto.AppWebCont.repository.ITransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TransactionServices {
    // creamos el servicio para traer todos los datos de la tabla transaciones
    private ITransactionRepository transactionRepository;

    public TransactionServices(ITransactionRepository repTransaction){
        this.transactionRepository=repTransaction;

    }
    public ArrayList<Transaction> selectAll(){
        return (ArrayList<Transaction>) this.transactionRepository.findAll();
    }

    public Transaction selectById(int Id){
        Optional<Transaction> existeMovimiento=this.transactionRepository.findById(Id);
        if(existeMovimiento.isPresent()){
            return existeMovimiento.get();
        }
        else{
            return null;
        }
    }
    // creamos una registro  en la tabla transaccion
    public Response createTransaction(Transaction newData){
        Response response=new Response();
        this.transactionRepository.save(newData);
        response.setCode(200);
        response.setMessage("Empresa registrada existosamente");
        return response;
    }


    public Response deleteTransactionById(int id){
        Response response= new Response();
        try{
            this.transactionRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("movimiento eliminado existosamente");
            return  response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error,"+ex.getMessage());
            return response;
        }
    }
}
