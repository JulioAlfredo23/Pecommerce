/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Controller;

import com.comercio.Model.DetalleOrden;
import com.comercio.Model.Orden;
import com.comercio.Model.Producto;
import com.comercio.Service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    
    Logger Logger=LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    ProductoService ProductoService;
    
    //para almacenar los detalles de la orden 
    List<DetalleOrden> detalles= new ArrayList<DetalleOrden>();
    // datos de la orden
    Orden orden =new Orden();
    
    @GetMapping("")
    public String home(Model model){

        model.addAttribute("producto",ProductoService.listarProductos());
        
        return "usuario/home";
    }   
    @GetMapping("/productohome/{id}")
    public String productoHome(@PathVariable Long id,Model model){
    
        Producto producto=new Producto();
        Optional<Producto> pOptional= ProductoService.get(id);
        producto=pOptional.get();
        
        model.addAttribute("producto", producto);
        Logger.info("id enviado como parametro : {}",id);

        
        return "usuario/productohome";
    }
    
    @PostMapping("/carrito")
    public String agregarCarrito(@RequestParam Long id,@RequestParam Integer cantidad, Model model){
        
        DetalleOrden detalleOrden=new DetalleOrden();
        Producto producto=new Producto();
        double sumaTotal=0;
        
        Optional<Producto> optionalProducto=ProductoService.get(id);
        Logger.info("Producto añadido : {}",optionalProducto.get());
        Logger.info("cantidad : {}",cantidad);
        
        producto=optionalProducto.get();
        
        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setTotal(producto.getPrecio()*cantidad);    
        detalleOrden.setProducto(producto);
        
        detalles.add(detalleOrden);
        
        sumaTotal=detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
        orden.setTotal(sumaTotal);
        model.addAttribute("carrito",detalles);
        model.addAttribute("orden",orden);
        
        return "usuario/carrito";
        
    }
    
}
