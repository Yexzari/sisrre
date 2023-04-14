package com.example.demo.models.dao.Reporte;

import com.example.demo.models.dao.Alumno.Alumno;
import com.example.demo.models.dao.Asesor.Asesor;
import com.example.demo.models.dao.Departamento.Departamento;
import com.example.demo.models.dao.Responsable.Responsable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reporte")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Reporte {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id_reporte;

        @Column(length = 150)
        private String archivo_nom;

        @Column(name = "contenido_archivo")
        @Lob
        private byte[] contenido_archivo;

        @Column(nullable = false)
        private long status;

        @Column( length = 200)
        private String comentario;

        @ManyToOne
        @JoinColumn(name = "asesorfk_id", nullable = false)
        private Asesor asesor;

        @OneToOne(mappedBy = "reporte")
        private Alumno alumno;

        @ManyToOne
        @JoinColumn(name = "responsablefk_id", nullable = false)
        private Responsable responsable;

        @ManyToOne
        @JoinColumn(name = "departamentofk_id", nullable = false)
        private Departamento departamento;



}
