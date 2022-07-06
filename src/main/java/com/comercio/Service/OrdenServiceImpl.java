/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Service;

import com.comercio.Model.Orden;
import com.comercio.Repository.OrdenRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImpl implements OrdenService{

    @Autowired
    OrdenRepository OrdenRepository;
    
    @Override
    public Orden save(Orden orden) {
    
        return OrdenRepository.save(orden);
    }

    @Override
    public List<Orden> findAll() {
    return OrdenRepository.findAll();
    }
    //metodo para generar numero de orden 
    
    public String generarNumeroOrden (){
    Integer numero=0;
    String numeroConcatenado="";
        
        List<Orden>ordenes=findAll();
    
        List<Integer> numeros=new ArrayList<Integer>();
        
        //java 8 - obteniendo el numero de orden
        ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));
        //indicando 
        if (ordenes.isEmpty()){
        numero=1;
        
        }else{
        numero=numeros.stream().max(Integer::compare).get();
        numero++;
        }
        if(numero<10){
        numeroConcatenado="000000000"+String.valueOf(numero);
       
        }else if(numero<100){
        numeroConcatenado="00000000"+String.valueOf(numero);
        }else if(numero<1000){
        numeroConcatenado="0000000"+String.valueOf(numero);
        }
        
        return numeroConcatenado;
    }
    
}
