/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Service;

import com.comercio.Model.Orden;
import com.comercio.Repository.OrdenRepository;
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
    
}
