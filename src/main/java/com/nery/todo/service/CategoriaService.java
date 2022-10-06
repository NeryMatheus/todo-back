package com.nery.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.todo.domain.Categoria;
import com.nery.todo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    
}
