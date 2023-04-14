package com.example.demo.models.dao.Reporte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReporteReposity extends JpaRepository<Reporte,Long> {


    @Query(value = "SELECT * FROM reporte WHERE alumnofk_id = ?", nativeQuery = true)
    List<Reporte> findStatus(@PathVariable("alumnofk_id") Long alumnofk_id);

    @Query(value = "SELECT * FROM reporte  WHERE status = 4", nativeQuery = true)
    List<Reporte> find4();

    @Query(value = "SELECT * FROM reporte  WHERE status = 3", nativeQuery = true)
    List<Reporte> find3();

    @Query(value = "SELECT * FROM reporte  WHERE status = 2", nativeQuery = true)
    List<Reporte> find2();

    @Query(value = "SELECT * FROM reporte  WHERE status = 1", nativeQuery = true)
    List<Reporte> find1();


}
