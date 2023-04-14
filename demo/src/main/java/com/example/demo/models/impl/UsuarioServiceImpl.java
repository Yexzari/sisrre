package com.example.demo.models.impl;

import com.example.demo.models.dao.UsuarioDao;
import com.example.demo.models.entity.Usuario;
import com.example.demo.models.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioDao usuarioDao;
    @Override
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    public Usuario registrar(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return usuarioDao.save(u);
    }
}
