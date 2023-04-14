package com.example.demo.models.controller.Controller_Roles;

import com.example.demo.models.dao.Reporte.Reporte;
import com.example.demo.models.dao.Reporte.ReporteReposity;
import com.example.demo.models.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api-sisrre/reporte")
@CrossOrigin(origins = {"*"})

public class Reporte_controller {

    @Autowired
    private ReporteService service;
    private ReporteReposity reposity;

    private Reporte reporte;


    @PostMapping("/reporte")
    public Reporte save(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Reporte fileEntity = new Reporte();
        fileEntity.setArchivo_nom(file.getOriginalFilename());
        fileEntity.setContenido_archivo(file.getBytes());
        fileEntity.setStatus(0);
        return this.reposity.save(fileEntity);
    }


    @GetMapping("/status/{alumnofk_id}")
    @ResponseBody
    public ResponseEntity<Object> getStatus(@PathVariable("alumnofk_id") Long alumnofk_id){
        return this.service.getStatus(alumnofk_id);
    }

    @GetMapping("/status4")
    @ResponseBody
    public ResponseEntity<List<Reporte>> getAll4(){
        return this.service.getStatus4();
    }

    @GetMapping("/status3")
    @ResponseBody
    public ResponseEntity<List<Reporte>> getAll3(){
        return this.service.getStatus3();
    }

    @GetMapping("/status2")
    @ResponseBody
    public ResponseEntity<List<Reporte>> getAll2(){
        return this.service.getStatus2();
    }

    @GetMapping("/status1")
    @ResponseBody
    public List<Reporte> getAll1(){
        List<Reporte> reportes = this.service.getStatus1();
        return reportes;
    }



}
