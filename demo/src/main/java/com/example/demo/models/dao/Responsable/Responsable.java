package com.example.demo.models.dao.Responsable;

import com.example.demo.models.dao.Asesor.Asesor;
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
@Table(name = "responsable")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_responsable;

    @Column(nullable = false, length = 150)
    private String nombre;
    @Column(nullable = false, length = 150)
    private String apellido_p;
    @Column(nullable = false, length = 150)
    private String apellido_m;

    @OneToMany(mappedBy = "responsable")
    @JsonIgnore
    private List<Asesor> asesor;

    @OneToMany(mappedBy = "responsable")
    @JsonIgnore
    private List<Reporte> reportes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id")
    private Usuario usuario;




}
