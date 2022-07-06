/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.comercio.Service;

import com.comercio.Model.Usuario;
import java.util.Optional;


public interface UsuarioService {
    
        Optional<Usuario>  findById(Long id);
        
        Usuario save(Usuario usuario);
    
    
}
