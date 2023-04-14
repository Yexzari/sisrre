package com.example.demo.models.entity;

import com.example.demo.models.dao.Alumno.Alumno;
import com.example.demo.models.dao.Asesor.Asesor;
import com.example.demo.models.dao.Departamento.Departamento;
import com.example.demo.models.dao.Responsable.Responsable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToOne(mappedBy = "usuario")
    private Alumno alumno;

    @OneToOne(mappedBy = "usuario")
    private Asesor asesor;
    @OneToOne(mappedBy = "usuario")
    private Responsable responsable;
    @OneToOne(mappedBy = "usuario")
    private Departamento departamento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Usuario() {
        super();
    }
    private static final long serialVersionUID = 1L;
}
