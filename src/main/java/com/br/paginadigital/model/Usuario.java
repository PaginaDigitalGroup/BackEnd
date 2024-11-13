package com.br.paginadigital.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "O Nome é obrigatório")
    @Size(max=255, message= "A descrição deve conter no máximo 255 caracteres")
    private String nome;

    @Schema(example = "email@email.com.br")
    @NotBlank (message= "O Usuário é obrigatório")
    @Email(message= "O Usuário deve ser um e-mail")
    private String usuario;


    @NotBlank (message = "O campo Senha é obrigatório")
    @Size(min=6, message= "A senha deve conter no mínimo 6 caracteres")
    private String senha;

    @Column(nullable = true)
    @Size(max=1000, message= "A foto deve conter no máximo 1000 caracteres")
    private String foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
