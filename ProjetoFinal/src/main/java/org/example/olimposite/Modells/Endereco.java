package org.example.olimposite.Modells;

public class Endereco {
    private int id;
    private String estado;
    private String municipio;
    private String bairro;
    private int idCLiente;
    public Endereco(int id, String estado, String municipio, String bairro, int idCLiente) {
        this.id = id;
        this.estado = estado;
        this.municipio = municipio;
        this.bairro = bairro;
        this.idCLiente = idCLiente;
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String cidade) {
        this.municipio = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getIdCLiente() {
        return idCLiente;
    }
}
