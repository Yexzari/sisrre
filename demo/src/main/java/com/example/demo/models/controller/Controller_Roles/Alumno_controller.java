package com.example.demo.models.controller.Controller_Roles;

import com.example.demo.models.dao.Alumno.Alumno;
import com.example.demo.models.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-sisrre/alumnos")
@CrossOrigin(origins = {"*"})
public class Alumno_controller {
    @Autowired
    private AlumnoService service;

    /*@GetMapping("/login")
    public ResponseEntity<Object> getLogin(@Valid @RequestBody String usu , String pass){
        return this.service.getLogin(usu, pass);
    }*/

    @GetMapping("/")
    public ResponseEntity<List<Alumno>> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public Alumno saveAlumno(
            @Valid @RequestBody Alumno alumno)
    {
        return service.saveAlumno(alumno);
    }
    @PutMapping("/{id}")
    public Alumno
    update(@RequestBody Alumno alumno,
                     @PathVariable("id") Long Id)
    {
        return service.updateAlumno(
                alumno, Id);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id")
                                       Long Id)
    {
        service.deleteById(
                Id);
        return "Deleted Successfully";
    }


}
