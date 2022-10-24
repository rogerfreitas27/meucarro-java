package com.meucarro.repository;

import com.meucarro.entity.Carro;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Long> {

    @Query(value = "SELECT COUNT(modelo_id) from  carro where modelo_id=:id", nativeQuery = true)
    public int contadorModeloNaTabelaCarro(Long id);





    @Query("SELECT c FROM Carro c JOIN c.modelo_id m WHERE lower(m.nome) LIKE  %:searchTerm%")
    Page<Carro> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

}