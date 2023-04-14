package com.example.demo.models.dao.Asesor;

import com.example.demo.models.dao.Alumno.Alumno;
import com.example.demo.models.dao.Reporte.Reporte;
import com.example.demo.models.dao.Responsable.Responsable;
import com.example.demo.models.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "asesor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Asesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_asesor;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 150)
    private String apellido_p;
    @Column(nullable = false, length = 150)
    private String apellido_m;


    @OneToMany(mappedBy = "asesor")
    @JsonIgnore
    private List<Alumno> alumnos;

    @ManyToOne
    @JoinColumn(name = "responsablefk_id", nullable = false)
    private Responsable responsable;

    @OneToMany(mappedBy = "asesor")
    @JsonIgnore
    private List<Reporte> reportes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id")
    private Usuario usuario;


}
