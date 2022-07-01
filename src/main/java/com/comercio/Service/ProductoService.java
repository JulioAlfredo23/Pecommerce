/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.comercio.Service;

import com.comercio.Model.Producto;
import java.util.List;
import java.util.Optional;


public interface ProductoService {
 
    public List<Producto> listarProductos();
    public Producto save (Producto producto);
    public Optional<Producto> get (Integer id);
    public void update (Producto producto);
    public void delete(Integer id);
    
    
}
