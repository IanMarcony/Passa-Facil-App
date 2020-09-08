package com.marcony.passafacilproject.firebasemodel;

public class PassaFacil {
    private int cod_passa_facil;
    private float saldo;


    public PassaFacil(int cod_passa_facil, float saldo) {
        this.cod_passa_facil = cod_passa_facil;
        this.saldo = saldo;
    }

    public int getCod_passa_facil() {
        return cod_passa_facil;
    }

    public void setCod_passa_facil(int cod_passa_facil) {
        this.cod_passa_facil = cod_passa_facil;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
