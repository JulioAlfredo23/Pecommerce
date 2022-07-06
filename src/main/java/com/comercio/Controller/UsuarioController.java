/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Controller;

import com.comercio.Model.Usuario;
import com.comercio.Service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    private final Logger logger=LoggerFactory.getLogger(UsuarioController.class);
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/registro")
    public String Registro(){
    return "usuario/registro";
        
    }
    
    @PostMapping("/guardar")
    public String guardar(Usuario usuario){
    
        usuario.setTipo("USER");
        usuarioService.save(usuario);
        
        logger.info("Usuario info : {}", usuario);
        
    return "redirect:/";
    }
    
}
