/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Service;

import com.comercio.Model.Usuario;
import com.comercio.Repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Optional<Usuario> findById(Long id) {
       return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
    return usuarioRepository.save(usuario);
    }
    
}
