package com.br.paginadigital.controller;

import com.br.paginadigital.model.Livro;
import com.br.paginadigital.repository.AutorRepository;
import com.br.paginadigital.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*", allowedHeaders= "*")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public ResponseEntity<List<Livro>> getAll(){
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getById(@PathVariable Long id){
        return livroRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Livro>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(livroRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Livro> postLivro(@Valid @RequestBody Livro livro){
        return autorRepository.findById(livro.getAutor().getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro)))
                .orElse(ResponseEntity.badRequest().build());
    }
    @PutMapping
    public ResponseEntity<Livro> putLivro(@Valid @RequestBody Livro livro){
        if(livroRepository.existsById(livro.getId())) {
            return autorRepository.findById(livro.getAutor().getId())
                    .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livro)))
                    .orElse(ResponseEntity.badRequest().build());
        }
        return ResponseEntity.notFound().build();
    }



    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Livro> putLivro(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        if (livroRepository.existsById(id)) {
            livro.setId(id); // Garantindo que o ID do livro a ser atualizado é o mesmo do passado na URL
            return autorRepository.findById(livro.getAutor().getId())
                    .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livro)))
                    .orElse(ResponseEntity.badRequest().build());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/situacao/{situacao}")
    public ResponseEntity<Livro> alterarSituacao(@PathVariable Long id, @PathVariable int situacao) {
        return livroRepository.findById(id)
                .map(livro -> {
                    livro.setSituacao(situacao);
                    livroRepository.save(livro);
                    return ResponseEntity.ok(livro);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLivro(@PathVariable Long id){
        return livroRepository.findById(id)
                .map(resposta ->{
                    livroRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
