package com.fina.decasal.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fina.decasal.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findByDataBetween(Date start, Date end);

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.categoria.id = :categoriaId")
    Double sumByCategoriaId(@Param("categoriaId") Long categoriaId);

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.pagador.id = :pagadorId AND d.data BETWEEN :inicio AND :fim")
    Double sumByPagadorIdAndDataBetween(@Param("pagadorId") Long pagadorId, @Param("inicio") Date inicio, @Param("fim") Date fim);

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.data BETWEEN :inicio AND :fim")
    Double sumByDataBetween(@Param("inicio") Date inicio, @Param("fim") Date fim);
}
