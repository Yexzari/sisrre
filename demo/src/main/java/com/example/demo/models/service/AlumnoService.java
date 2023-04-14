package com.example.demo.models.service;

import com.example.demo.models.dao.Alumno.Alumno;
import com.example.demo.models.dao.Alumno.AlumnoReposity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class AlumnoService {
    @Autowired
    private AlumnoReposity repository_a;

    /*@Transactional(readOnly = true)
    public ResponseEntity getLogin(String usuario , String pass){
        return new ResponseEntity<>(this.repository_a.findLogin(usuario , pass ), HttpStatus.OK);
    }*/

    @Transactional(readOnly = true)
    public ResponseEntity<List<Alumno>> getAll(){
        return new ResponseEntity<>(this.repository_a.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity(this.repository_a.findById(id),HttpStatus.OK);
    }
    @Transactional
    public Alumno saveAlumno(Alumno alumno)

    {
        return repository_a.save(alumno);
    }

    @Transactional
    public Alumno
    updateAlumno(Alumno alumno,
                     Long Id)
    {
        Alumno depDB
                = repository_a.findById(Id)
                .get();

        if (Objects.nonNull(alumno.getNombre())
                && !"".equalsIgnoreCase(
                alumno.getNombre())) {
            depDB.setNombre(
                    alumno.getNombre());
        }

        if (Objects.nonNull(
                alumno.getMatricula())
                && !"".equalsIgnoreCase(
                alumno.getMatricula())) {
            depDB.setMatricula(
                    alumno.getMatricula());
        }


        return repository_a.save(depDB);
    }

    // Delete operation
    @Transactional
    public void deleteById(Long Id)
    {
        repository_a.deleteById(Id);
    }
}
