package com.example.demo.models.dao.Alumno;

import com.example.demo.models.dao.Asesor.Asesor;
import com.example.demo.models.dao.Reporte.Reporte;
import com.example.demo.models.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "alumno")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_alumno;
    @Column(nullable = false, unique = true, length = 150)
    private String matricula;
    @Column(nullable = false, length = 150)
    private String carrera;
    @Column(nullable = false, length = 8)
    private String nombre;
    @Column(nullable = false, length = 150)
    private String apellido_p;
    @Column(nullable = false, length = 150)
    private String apellido_m;


    @ManyToOne
    @JoinColumn(name = "asesorfk_id", nullable = false)
    private Asesor asesor;

    @OneToOne
    @JoinColumn(name = "reporte_fk", nullable = false, referencedColumnName = "id_reporte")
    private Reporte reporte;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id")
    private Usuario usuario;

}

    //hello suckers
    //hello Jesus

