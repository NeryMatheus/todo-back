package com.nery.todo.dtos;

import java.io.Serializable;

import com.nery.todo.domain.Lembrete;

public class LembreteDTO implements Serializable{
    private Integer id;
    private String titulo;
    private String status;
    
    public LembreteDTO() {
        super ();
    }

    public LembreteDTO(Lembrete lembrete) {
        this.id = lembrete.getId();
        this.titulo = lembrete.getTitulo();
        this.status = lembrete.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
}
