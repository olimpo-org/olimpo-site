package org.example.olimposite.Modells;

public class Admin {
    private int id;
    private String usuario;
    private String senha;

    public Admin(int id, String usuario, String senha){
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }
}
