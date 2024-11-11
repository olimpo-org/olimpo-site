package org.example.olimposite.Modells;

public class Interesse {
    private int id;
    private String nome;

    public Interesse(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
