package br.ufscar.dc.dsw.domain;

public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private Integer ano;
    private Float preco;
    private Hotel editora;

    public Livro(Long id) {
        this.id = id;
    }

    public Livro(String titulo, String autor, Integer ano, Float preco,
            Hotel editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.preco = preco;
        this.editora = editora;
    }

    public Livro(Long id, String titulo, String autor, Integer ano, 
            Float preco, Hotel editora) {
        this(titulo, autor, ano, preco, editora);
        this.id = id;
    }

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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Hotel getEditora() {
        return editora;
    }

    public void setEditora(Hotel editora) {
        this.editora = editora;
    }
    
    @Override
    public String toString() {
    	return titulo + ", " + autor + "(" + preco + ")"; 
    }
}
