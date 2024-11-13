package com.br.paginadigital.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    @NotNull(message="O campo é obrigatório!")
    @Min(value = 1, message="O número de páginas deve ser pelo menos {value}.")
    @Max(value = 10000, message="O número de páginas não pode exceder {value}.")
    private Integer numeroPaginas;

    @NotBlank(message="O campo é obrigatório!")
    @Size(min = 5, max = 10000, message="Este campo deve conter no mínimo 5 e máximo 100 caracteres.")
    private String descricao;

    @NotBlank(message="O campo é obrigatório!")
    @Size(min = 5, max = 100, message="Este campo deve conter no mínimo 5 e máximo 100 caracteres.")
    private String genero;

    //private boolean situacao;
    @Min(value = 0, message="A situação deve ser um valor positivo.")
    @Max(value = 1, message="A situação deve ser 0 ou 1.")
    private int situacao;

    @ManyToOne
    @JsonIgnoreProperties("livro")
    @JoinColumn(name = "tb_autor_id")
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

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
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
