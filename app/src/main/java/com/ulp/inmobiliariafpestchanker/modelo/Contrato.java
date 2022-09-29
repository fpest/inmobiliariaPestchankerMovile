package com.ulp.inmobiliariafpestchanker.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Contrato implements Serializable {

    private int idContrato;
    private String fechaInicio;
    private String fechaFin;
    private double montoAlquiler;
    private com.ulp.inmobiliariafpestchanker.modelo.Inquilino inquilino;
    private com.ulp.inmobiliariafpestchanker.modelo.Inmueble inmueble;

    public Contrato() {}
    public Contrato(int idContrato, String fechaInicio, String fechaFin, double montoAlquiler, com.ulp.inmobiliariafpestchanker.modelo.Inquilino inquilino, com.ulp.inmobiliariafpestchanker.modelo.Inmueble inmueble) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoAlquiler = montoAlquiler;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(double montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }


    public com.ulp.inmobiliariafpestchanker.modelo.Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(com.ulp.inmobiliariafpestchanker.modelo.Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public com.ulp.inmobiliariafpestchanker.modelo.Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(com.ulp.inmobiliariafpestchanker.modelo.Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return idContrato == contrato.idContrato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContrato);
    }
}
