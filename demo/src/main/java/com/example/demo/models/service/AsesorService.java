package com.example.demo.models.service;


import com.example.demo.models.dao.Asesor.Asesor;
import com.example.demo.models.dao.Asesor.AsesorReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class AsesorService {
    @Autowired
    private AsesorReposity repository_ase;

    @Transactional(readOnly = true)
    public ResponseEntity<List<Asesor>> getAll(){
        return new ResponseEntity<>(this.repository_ase.findAll(),HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity<Object>(this.repository_ase.findById(id), HttpStatus.OK);
    }

    @Transactional
        public Asesor save(Asesor asesor)
        {
            return repository_ase.save(asesor);
        }

        @Transactional
        public Asesor
        updatePoke(Asesor asesor,
                   Long Id)
        {
            Asesor depDB
                    = repository_ase.findById(Id)
                    .get();

            if (Objects.nonNull(asesor.getName())
                    && !"".equalsIgnoreCase(
                    asesor.getName())) {
                depDB.setName(
                        asesor.getName());
            }

            if (Objects.nonNull(
                    asesor.getApellido_p())
                    && !"".equalsIgnoreCase(
                    asesor.getApellido_p())) {
                depDB.setApellido_p(
                        asesor.getApellido_p());
            }



            return repository_ase.save(depDB);
        }

        // Delete operation
        @Transactional
        public void deleteById(Long Id)
        {
            repository_ase.deleteById(Id);
        }

    }

