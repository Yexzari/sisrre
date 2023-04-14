package com.example.demo.models.dao.Asesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorReposity extends JpaRepository<Asesor,Long> {

        }
