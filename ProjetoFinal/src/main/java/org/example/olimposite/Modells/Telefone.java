package org.example.olimposite.Modells;

public class Telefone {
    private int id;
    private String telefone;
    private int idCliente;
    public Telefone(int id, String telefone, int idCliente){
        this.id = id;
        this.telefone = telefone;
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getId() {
        return id;
    }
}
