package com.br.paginadigital.controller;

import java.util.List;

import javax.validation.Valid;

import com.br.paginadigital.model.Autor;
import com.br.paginadigital.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public ResponseEntity <List<Autor>>getAll(){
        return ResponseEntity.ok(autorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Autor> getById(@PathVariable Long id){
        return autorRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity <List<Autor>> getByAutor(@PathVariable String autor){
        return ResponseEntity.ok(autorRepository.findAllByNomeContainingIgnoreCase(autor));
    }

    @PostMapping
    public ResponseEntity <Autor> postAutor(@Valid @RequestBody Autor autor){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorRepository.save(autor));
    }

    @PutMapping
    public ResponseEntity <Autor> putAutor(@Valid @RequestBody Autor autor){
        return autorRepository.findById(autor.getId())
                .map(resposta ->{
                    return ResponseEntity.ok().body(autorRepository.save(autor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteAutor(@PathVariable Long id){
        return autorRepository.findById(id)
                .map(resposta ->{
                    autorRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
