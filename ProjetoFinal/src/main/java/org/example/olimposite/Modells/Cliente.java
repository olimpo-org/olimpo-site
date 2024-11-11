package org.example.olimposite.Modells;

public class Cliente {
    private int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String cpf;
    private int gender_id;
    private int interest_id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }
    public int getGender_id() {
        return this.gender_id;
    }

    public int getInterest_id() {
        return this.interest_id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Cliente(int id, String email, String password, String name, String surname, String cpf, int gender_id, int interest_id){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.gender_id = gender_id;
        this.interest_id = interest_id;
    }
}
