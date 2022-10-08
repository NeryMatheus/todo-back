package com.nery.todo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nery.todo.domain.Lembrete;
import com.nery.todo.dtos.LembreteDTO;
import com.nery.todo.service.LembreteService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/lembretes")
public class LembreteResource {
    
    @Autowired
    private LembreteService ls;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Lembrete> findById(@PathVariable Integer id)
    {
        Lembrete lem = ls.findById(id);
        return ResponseEntity.ok().body(lem);
    }

    @GetMapping
    public ResponseEntity<List<LembreteDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat)
    {
        List<Lembrete> l = ls.findAll(id_cat);
        List<LembreteDTO> lDTO = l.stream().map(x -> new LembreteDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(lDTO);
    }

}
