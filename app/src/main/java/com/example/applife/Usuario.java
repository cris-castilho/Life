package com.example.applife;

class Usuario {
    int id;
    String nome;
    String sexo;
    String email;

    public Usuario(){}

    public Usuario(int id, String nome, String sexo, String email) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
    }

    public Usuario( String nome, String sexo, String email) {
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
