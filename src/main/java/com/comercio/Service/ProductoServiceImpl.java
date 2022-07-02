/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.comercio.Service;

import com.comercio.Model.Producto;
import com.comercio.Repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository pr ;
    
    @Override
    public Producto save(Producto producto) {
      return pr.save(producto);
        
    }
//    OPTIONAL<T> AYUDA A MANEJAR LOS NULOS 
    @Override
    public Optional<Producto> get(Long id) {
    return pr.findById(id);
    }

    @Override
    public void update(Producto producto) {
    pr.save(producto);
    }

    @Override
    public void delete(long id) {
    pr.deleteById(id);
    }

    @Override
    public List<Producto> listarProductos() {
        return pr.findAll();
    }
    
}
