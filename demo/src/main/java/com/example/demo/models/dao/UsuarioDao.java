package com.example.demo.models.dao;

import com.example.demo.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long > {
    public Usuario findByUsername(String username);

}
