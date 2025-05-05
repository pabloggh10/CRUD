package com.upiiz.crud.models;

import java.time.LocalDate;

public class TransaccionesModel {
    private int id_transaccion;
    private int id_cuenta;
    private LocalDate fecha;
    private String tipo;
    private Double monto;

    public TransaccionesModel() {

    }

    public TransaccionesModel(int id_transaccion, int id_cuenta, LocalDate fecha, String tipo, Double monto) {
        this.id_transaccion = id_transaccion;
        this.id_cuenta = id_cuenta;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
