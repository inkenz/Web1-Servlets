package br.ufscar.dc.dsw.domain;

public class Hotel {

    private String CNPJ;
    private String senha;
    private String nome;
    private String email;
    private String cidade;

    public Hotel(Long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Hotel(String CNPJ, String nome) {
        this.CNPJ = CNPJ;
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdeLivros() {
        return qtdeLivros;
    }

    public void setQtdeLivros(int qtdeLivros) {
        this.qtdeLivros = qtdeLivros;
    }
}