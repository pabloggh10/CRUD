package com.upiiz.crud.models;


public class CuentasModel {
    private int id_cuenta;
    private String titular;
    private String tipo_cuenta;
    private double saldo;

    public CuentasModel() {

    }

    public CuentasModel(int id_cuenta, String titular, String tipo_cuenta, double saldo) {
        this.id_cuenta = id_cuenta;
        this.titular = titular;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo = saldo;

    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
