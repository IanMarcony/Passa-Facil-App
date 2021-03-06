package com.marcony.passafacilproject.firebasemodel;

public class User {
    private String uid;
    private String nome;
    private String email;
    private String datnasc;
    private String sexo;
    private String cpf;
    private String rg;
    private  String endereco;
    private PassaFacil cod_passa_facil;

    public User(String uid, String nome, String email, String datnasci, String sexo, String cpf, String rg, String endereco) {
        this.uid = uid;
        this.nome = nome;
        this.email = email;
        this.datnasc = datnasci;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatnasci() {
        return datnasc;
    }

    public void setDatnasci(String datnasci) {
        this.datnasc = datnasci;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getDatnasc() {
        return datnasc;
    }

    public void setDatnasc(String datnasc) {
        this.datnasc = datnasc;
    }

    public PassaFacil getCod_passa_facil() {
        return cod_passa_facil;
    }

    public void setCod_passa_facil(PassaFacil cod_passa_facil) {
        this.cod_passa_facil = cod_passa_facil;
    }
}
