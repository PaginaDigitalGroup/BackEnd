package com.br.paginadigital.controller;

import com.br.paginadigital.model.Usuario;
import com.br.paginadigital.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders= "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        // Salva o usuário no banco de dados
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        // Retorna o usuário salvo com o status HTTP 201 (Criado)
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }

    // Método para logar o usuário
    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUsuario(@RequestBody Usuario usuario) {
        // Tenta buscar um usuário com o email (usuario) e senha passados
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByUsuario(usuario.getUsuario());

        // Verifica se o usuário foi encontrado e se a senha bate
        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getSenha().equals(usuario.getSenha())) {
            // Remove a senha do objeto Usuario antes de retornar para o frontend
            Usuario usuarioSemSenha = usuarioEncontrado.get();
            usuarioSemSenha.setSenha(null);  // Remover a senha para não retornar ao frontend

            // Retorna o objeto Usuario completo (sem a senha)
            return ResponseEntity.ok(usuarioSemSenha);
        } else {
            // Se o usuário ou a senha não corresponderem, retorna um erro 401
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}
