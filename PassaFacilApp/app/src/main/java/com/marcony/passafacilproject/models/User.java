package com.marcony.passafacilproject.models;

public class User {
    private String name;
    private  String birthdate;
    private String numPass;
    private  String sexo;
    private String cpf, rg;
    private String endereco;
    private  String email;
    private String password;

    public User(String name, String birthdate, String numPass, String sexo, String cpf, String rg, String endereco, String email, String password) {
        this.name = name;
        this.birthdate = birthdate;
        this.numPass = numPass;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNumPass() {
        return numPass;
    }

    public void setNumPass(String numPass) {
        this.numPass = numPass;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
