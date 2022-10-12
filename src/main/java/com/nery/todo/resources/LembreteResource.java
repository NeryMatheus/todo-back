package com.nery.todo.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nery.todo.domain.Lembrete;
import com.nery.todo.dtos.LembreteDTO;
import com.nery.todo.repositories.LembreteRepository;
import com.nery.todo.service.LembreteService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/lembretes")
public class LembreteResource {
    
    @Autowired
    private LembreteService ls;

    @Autowired
    private LembreteRepository lr;

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

    @GetMapping(value = "/data/{data}")
    public ResponseEntity<List<Lembrete>> findByData(@PathVariable String data)
    {
        List<Lembrete> lem = ls.findByData(data);
        return ResponseEntity.ok().body(lem);
    }

    @GetMapping(value = "/status/{status}")
    public ResponseEntity<List<Lembrete>> findByStatus(@PathVariable String status)
    {
        List<Lembrete> lem = ls.findByStatus(status);
        return ResponseEntity.ok().body(lem);
    }

    // @GetMapping(value = "/data/{data}")
    // public List<Lembrete> findByData(@PathVariable("data") String data)
    // {
    //     return lr.findByData(data);
    // }

    // @GetMapping(value = "/status/{status}")
    // public List<Lembrete> findByStatus(@PathVariable("status") String status)
    // {
    //     return lr.findByStatus(status);
    // }

    @PostMapping
    public ResponseEntity<Lembrete> create (@RequestParam(value = "categoria", defaultValue = "0") Integer id_lemb, @Valid @RequestBody Lembrete lem ){
        Lembrete newLemb = ls.create(id_lemb, lem);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/lembretes/{id}").buildAndExpand(newLemb.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Lembrete> update (@PathVariable Integer id, @Valid @RequestBody Lembrete lem){
        Lembrete newLem = ls.update(id, lem);
        return ResponseEntity.ok().body(newLem);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id)
    {
        ls.delete(id);
        return ResponseEntity.noContent().build();
    }

}
