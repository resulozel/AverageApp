package com.example.resulozel.ortalamaapp;

/**
 * Created by Emre on 16.12.2017.
 */

public class Dersler {

    private String dersAdi;
    private double dersKredi;
    private double dersNotu;

    public Dersler(String dersAdi, double dersKredi, double dersNotu) {
        this.dersAdi = dersAdi;
        this.dersKredi = dersKredi;
        this.dersNotu = dersNotu;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public double getDersKredi() {
        return dersKredi;
    }

    public void setDersKredi(double dersKredi) {
        this.dersKredi = dersKredi;
    }

    public double getDersNotu() {
        return dersNotu;
    }

    public void setDersNotu(double dersNotu) {
        this.dersNotu = dersNotu;
    }
}
