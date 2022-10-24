package com.meucarro.repository;

import com.meucarro.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo,Long> {


    @Query(value = "SELECT COUNT(marca_id) FROM  modelo WHERE marca_id=:id", nativeQuery = true)
    public int contadorDeMarcasNaTabelaModelo(Long id);

    @Query(value = "SELECT * FROM  modelo WHERE marca_id=:id", nativeQuery = true)
    public List<Modelo> findAllByMarca(Long id);

}