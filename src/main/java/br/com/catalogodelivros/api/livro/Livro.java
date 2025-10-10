package br.com.catalogodelivros.api.livro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 1. Avisa ao JPA que esta classe representa uma tabela no banco de dados.
public class Livro {

    @Id // 2. Marca o campo "id" como a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. Configura o ID para ser gerado automaticamente pelo banco.
    private Long id;

    private String titulo;
    private String autor;
    private int anoPublicacao;

    // 4. Getters e Setters: O JPA precisa deles para acessar os campos.
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
