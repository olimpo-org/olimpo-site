package org.example.olimposite.Modells;

public class AnuncioDTO {
    private int id;
    private String titulo;
    private String descricao;
    private String categoria;
    private double preco;
    private String linkImagem;


    public AnuncioDTO(int id, String titulo, String descricao, String categoria, double preco, String linkImagem){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.linkImagem = linkImagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public int getId() {
        return id;
    }
}
