package com.example.demo.models.service;

import com.example.demo.models.dao.Reporte.Reporte;
import com.example.demo.models.dao.Reporte.ReporteReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ReporteService {
    @Autowired
    private ReporteReposity repository;

    @Transactional(readOnly = true)
    public ResponseEntity getStatus(Long id_alumno){
        return new ResponseEntity(this.repository.findStatus(id_alumno), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Reporte>> getStatus4(){
        return new ResponseEntity<>(this.repository.find4(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Reporte>> getStatus3(){
        return new ResponseEntity<>(this.repository.find3(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Reporte>> getStatus2(){
        return new ResponseEntity<>(this.repository.find2(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public List<Reporte> getStatus1(){
        List<Reporte> reportes = this.repository.find1();
        return reportes;
    }


}
