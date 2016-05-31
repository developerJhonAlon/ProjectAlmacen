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
public class Almacen implements Serializable{
    private static final long serialVersionUID = 1L;

    private int idAlmacen;
    private int numero;
    private String direccion;
    private String telefono;
    private boolean estado;
    
    public Almacen(){}

    public Almacen(int idAlmacen, int numero, String direccion, String telefono) {
        this.idAlmacen = idAlmacen;
        this.numero = numero;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    
    
    public Almacen(int idAlmacen, int numero, String direccion, String telefono, boolean estado) {
        this.idAlmacen = idAlmacen;
        this.numero = numero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    
    public Almacen(int numero, String direccion, String telefono, boolean estado) {
        this.numero = numero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
           
}
