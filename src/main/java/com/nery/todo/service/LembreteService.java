package com.nery.todo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.todo.domain.Categoria;
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

    public Lembrete create(Integer id_lemb, Lembrete lem) {
        lem.setId(null);
        Categoria cat = cs.findById(id_lemb);
        lem.setCategoria(cat);
        return lr.save(lem);
    }

    public Lembrete update(Integer id, Lembrete lem) {
        Lembrete newLem = findById(id);
        updateData(newLem, lem);
        return lr.save(newLem);
    }

    private void updateData(Lembrete newLem, Lembrete lem) {
        newLem.setTitulo(lem.getTitulo());
        newLem.setAutor(lem.getAutor());
        newLem.setDescricao(lem.getDescricao());
        newLem.setData(lem.getData());
        newLem.setStatus(lem.getStatus());

    }

    public void delete(Integer id) {
        Lembrete lem = findById(id);
        lr.delete(lem);
    }

    public List<Lembrete> findByData(String data) {       
        return lr.findByData(data);
    }

    public List<Lembrete> findByStatus(String status) {
        return lr.findByStatus(status);
    }

}
