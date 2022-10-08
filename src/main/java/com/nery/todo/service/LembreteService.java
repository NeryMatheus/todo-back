package com.nery.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.todo.domain.Lembrete;
import com.nery.todo.exceptions.ObjectNotFoundExceptions;
import com.nery.todo.repositories.LembreteRepository;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lr;

    @Autowired
    private CategoriaService cs;

    public Lembrete findById(Integer id) {
        Optional<Lembrete> lem = lr.findById(id);
        return lem.orElseThrow(() -> new ObjectNotFoundExceptions("Lembrete não encontrado. Id: " + id + ". Tipo: " + Lembrete.class.getName(), null));
    }

    public List<Lembrete> findAll(Integer id_cat) {
        cs.findById(id_cat);
        return lr.findLembretes(id_cat);
    }
    
}
