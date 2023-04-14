package com.example.demo.models.service;

import com.example.demo.models.entity.Usuario;

public interface UsuarioService {
    public Usuario findByUsername(String username);
    public Usuario registrar(Usuario u);
}
