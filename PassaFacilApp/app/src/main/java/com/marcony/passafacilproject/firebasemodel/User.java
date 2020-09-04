package com.marcony.passafacilproject.firebasemodel;

public class User {
    private String uid;
    private String nome;
    private String email;
    private String datnasci;
    private String sexo;
    private String cpf;
    private String rg;
    private  String endereco;
    private int cod_passa_facil;

    public User(String uid, String nome, String email, String datnasci, String sexo, String cpf, String rg, String endereco, int cod_passa_facil) {
        this.uid = uid;
        this.nome = nome;
        this.email = email;
        this.datnasci = datnasci;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.cod_passa_facil = cod_passa_facil;
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
        return datnasci;
    }

    public void setDatnasci(String datnasci) {
        this.datnasci = datnasci;
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

    public int getCod_passa_facil() {
        return cod_passa_facil;
    }

    public void setCod_passa_facil(int cod_passa_facil) {
        this.cod_passa_facil = cod_passa_facil;
    }
}
