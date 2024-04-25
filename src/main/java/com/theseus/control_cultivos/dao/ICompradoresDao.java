package com.theseus.control_cultivos.dao;

import com.theseus.control_cultivos.entities.Compradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompradoresDao extends JpaRepository<Compradores, Integer> {
    @Query("select c from Compradores c where c.nombre like ?1")
    public List<Compradores> findByNombre(String nombre);
}
