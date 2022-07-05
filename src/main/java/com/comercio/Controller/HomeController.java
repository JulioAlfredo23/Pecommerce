/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Controller;

import com.comercio.Model.Producto;
import com.comercio.Service.ProductoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    
    Logger Logger=LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    ProductoService ProductoService;
    
    @GetMapping("")
    public String home(Model model){

        model.addAttribute("producto",ProductoService.listarProductos());
        
        return "usuario/home";
    }   
    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Long id){
    
        Logger.info("id enviado como parametro : {}",id);

        
        return "usuario/productohome";
    }
    
}
