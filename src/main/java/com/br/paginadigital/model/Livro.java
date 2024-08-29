package com.br.paginadigital.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O campo é obrigatório!")
    @Size(min = 5, max = 100, message="Este campo deve conter no mínimo 5 e máximo 100 caracteres.")
    private String titulo;

    @NotBlank(message="O campo é obrigatório!")
    @Size(min = 5, max = 100, message="Este campo deve conter no mínimo 5 e máximo 100 caracteres.")
    private String editora;

    @NotBlank(message="O campo é obrigatório!")
    @Size(min = 5, max = 100, message="Este campo deve conter no mínimo 5 e máximo 100 caracteres.")
    private int numeroPaginas;

    @NotBlank(message="O campo é obrigatório!")
    @Size(min = 5, max = 1000, message="Este campo deve conter no mínimo 5 e máximo 100 caracteres.")
    private String descricao;

    @NotBlank(message="O campo é obrigatório!")
    @Size(min = 5, max = 100, message="Este campo deve conter no mínimo 5 e máximo 100 caracteres.")
    private String genero;

    @NotBlank(message="O campo é obrigatório!")
    @Size(min = 5, max = 1000, message="Este campo deve conter no mínimo 5 e máximo 100 caracteres.")
    private boolean situacao;

    @ManyToOne
    @JsonIgnoreProperties("autor")
    private Autor autor;

    @Size(max = 1000, message="Este campo deve conter no máximo 1000 caracteres.")
    private String foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
