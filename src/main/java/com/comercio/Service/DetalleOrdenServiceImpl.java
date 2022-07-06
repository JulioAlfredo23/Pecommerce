/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Service;

import com.comercio.Model.DetalleOrden;
import com.comercio.Repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenIService{

    @Autowired
    private DetalleOrdenRepository DetalleOrdenR;
    @Override
    public DetalleOrden save(DetalleOrden DetalleOrden) {
        
        return DetalleOrdenR.save(DetalleOrden);
    }
    
}
