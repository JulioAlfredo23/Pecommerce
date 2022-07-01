
package com.comercio.Controller;

import com.comercio.Model.Producto;
import com.comercio.Model.Usuario;
import com.comercio.Service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService PS;
    
    private final Logger loger=LoggerFactory.getLogger(ProductoController.class);
    
    @GetMapping("/")
    public String show(){
    
        return "productos/show";
    }
    @GetMapping("/create")
    public String create(){
    
        return "productos/create";
        
    }
    
    @PostMapping("/save")
    public String save(Producto producto){
        Usuario u= new Usuario(1l, "", "", "", "", "", "", "");
        
        producto.setUsuario(u);
        PS.save(producto);
        loger.info("Este es el objeto producto {}",producto);
    return "redirect:/productos/";
    }
       
}
