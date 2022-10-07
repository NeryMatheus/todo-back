package com.nery.todo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nery.todo.domain.Categoria;
import com.nery.todo.dtos.CategoriaDTO;
import com.nery.todo.exceptions.ObjectNotFoundExceptions;
import com.nery.todo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional <Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não encontrado! Id: " + id + ". Tipo: " + Categoria.class.getName(), null));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria cat) {
        cat.setId(null);
        return categoriaRepository.save(cat);
    }

    public Categoria update(@Valid Integer id, CategoriaDTO catDTO) {
        Categoria cat = findById(id);
        cat.setNome(catDTO.getNome());
        cat.setDesc(catDTO.getDesc());
        return categoriaRepository.save(cat);
    }

    public void delete(Integer id) {
        findById(id);
        try{
            categoriaRepository.deleteById(id);
        }catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Categoria não pode ser excluída pois possui livros associados!!");
        }
    }
    
}
