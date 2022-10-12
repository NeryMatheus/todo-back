package com.nery.todo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nery.todo.domain.Lembrete;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Integer> {

    /**
     * @param id_cat
     * @return
     */
    @Query("SELECT obj FROM Lembrete obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
    List<Lembrete> findLembretes(@Param(value = "id_cat") Integer id_cat);

    List<Lembrete> findByData(String data);

    List<Lembrete> findByStatus(String status);

}
