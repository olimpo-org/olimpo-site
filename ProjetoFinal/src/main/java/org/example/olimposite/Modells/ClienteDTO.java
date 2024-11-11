package org.example.olimposite.Modells;

public class ClienteDTO {
    private int idCliente;
    private String nome;
    private String sobrenome;
    private String email;
    private String principal_interesse;
    private String estado;
    private String telefone;
    public ClienteDTO(int idCliente, String nome, String sobrenome, String email, String principal_interesse, String telefone, String estado){
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.principal_interesse = principal_interesse;
        this.telefone = telefone;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getPrincipal_interesse() {
        return principal_interesse;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }
}