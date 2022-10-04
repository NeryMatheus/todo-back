package com.nery.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nery.todo.domain.Lembrete;

public interface LembreteRepository extends JpaRepository<Lembrete, Integer> {
    
}
