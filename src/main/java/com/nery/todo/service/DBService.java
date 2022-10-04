package com.nery.todo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.todo.domain.Categoria;
import com.nery.todo.domain.Lembrete;
import com.nery.todo.repositories.CategoriaRepository;
import com.nery.todo.repositories.LembreteRepository;

@Service
public class DBService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LembreteRepository lembreteRepository;

    public void instanciaBasedeDados() {
        Categoria cat1 = new Categoria(null, "Casa", "Lembretes para casa");
        Categoria cat2 = new Categoria(null, "Trabalho", "Lembretes para trabalho");
        Categoria cat3 = new Categoria(null, "Estudos", "Lembretes para estudos");

        Lembrete lembrete1 = new Lembrete(null, "Lavar a louça", "Matheus Nery", "Lavar a louça antes que a minha mãe chegue.", null, "CRIADO", cat1);
        Lembrete lembrete2 = new Lembrete(null, "Estudar Java", "Matheus Nery", "Estudar Java para a prova de amanhã.", null, "CRIADO", cat3);
        Lembrete lembrete3 = new Lembrete(null, "Estudar Angular", "Matheus Nery", "Estudar Angular para a prova de amanhã.", null, "CRIADO", cat3);
        Lembrete lembrete4 = new Lembrete(null, "Estudar Spring", "Matheus Nery", "Estudar Spring para a prova de amanhã.", null, "CRIADO", cat3);

        cat1.getLembretes().addAll(Arrays.asList(lembrete1));
        cat3.getLembretes().addAll(Arrays.asList(lembrete2, lembrete3, lembrete4));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.lembreteRepository.saveAll(Arrays.asList(lembrete1, lembrete2, lembrete3, lembrete4));
    }
}
