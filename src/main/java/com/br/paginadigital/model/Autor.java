package com.br.paginadigital.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="tb_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O atributo nome é obrigatório!")
    @Size(max=255, message="O atributo autor deve conter no máximo 255 caracteres")
    private String nome;


    @NotBlank(message="O atributo descrição é obrigatório e não pode conter espaços em branco!")
    @Size(max=5000,min=10,message="O atributo descrição deve conter no mínimo 10 e no máximo 255 caracteres")
    private String descricao;

    @OneToMany(mappedBy="autor", cascade=CascadeType.ALL)
    @JsonIgnoreProperties("autor")
    private List<Livro> livro;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivro() {
        return livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }
}
