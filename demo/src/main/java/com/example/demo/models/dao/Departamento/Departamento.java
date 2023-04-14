package com.example.demo.models.dao.Departamento;

import com.example.demo.models.dao.Reporte.Reporte;
import com.example.demo.models.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departamento")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_departamento;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 150)
    private String apellidoP;
    @Column(nullable = false, length = 150)
    private String apellidoM;


    @OneToMany(mappedBy = "departamento")
    @JsonIgnore
    private List<Reporte> reportes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id")
    private Usuario usuario;

}
