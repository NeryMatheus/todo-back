package com.nery.todo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O campo nome é obrigatório!!")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "O campo descrição é obrigatório!!")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres")
    private String desc;

    @OneToMany(mappedBy = "categoria")
    private List<Lembrete> lembretes = new ArrayList<>();

    public Categoria() {
        super();
    }

    public Categoria(Integer id,
            @NotEmpty(message = "O campo nome é obrigatório!!") @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres") String nome,
            @NotEmpty(message = "O campo descrição é obrigatório!!") @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres") String desc) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());       
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;        
        return true;
    }

    
}
