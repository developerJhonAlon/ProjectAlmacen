/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camiones.modelo;

import java.io.Serializable;

/**
 *
 * @author Jhonny
 */
public class Camion implements Serializable {
     private static final long serialVersionUID = 1L;
     private int idCamion;
     private String matricula;
     private int maxVolumen;
     private int maxPeso;
     private boolean estado;
     
     
     public Camion(){}

    public Camion(int idCamion, String matricula, int maxVolumen, int maxPeso, boolean estado) {
        this.idCamion = idCamion;
        this.matricula = matricula;
        this.maxVolumen = maxVolumen;
        this.maxPeso = maxPeso;
        this.estado = estado;
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getMaxVolumen() {
        return maxVolumen;
    }

    public void setMaxVolumen(int maxVolumen) {
        this.maxVolumen = maxVolumen;
    }

    public int getMaxPeso() {
        return maxPeso;
    }

    public void setMaxPeso(int maxPeso) {
        this.maxPeso = maxPeso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
     
     
     
}
