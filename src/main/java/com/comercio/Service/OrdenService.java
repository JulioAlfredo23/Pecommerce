/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.comercio.Service;

import com.comercio.Model.Orden;
import java.util.List;

public interface OrdenService {
    
    List<Orden> findAll();
    Orden save(Orden orden);
    String generarNumeroOrden();
    
    
}
