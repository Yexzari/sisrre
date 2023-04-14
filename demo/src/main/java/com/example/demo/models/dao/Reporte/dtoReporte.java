package com.example.demo.models.dao.Reporte;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class dtoReporte {
    private long id_reporte;

    private String archivo_nom;

    private byte[] contenido_archivo;

    private long status;

    private String comentario;

    public Reporte getReporte(){
        return new Reporte(
                getId_reporte(),
                getArchivo_nom(),
                getContenido_archivo(),
                getStatus(),
                getComentario(),
                null,
                null,
                null,
                null
        );
    }
}
