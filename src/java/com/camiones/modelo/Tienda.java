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
public class Tienda implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int idTienda;
    private String nombre;
    private String direccion;
    private String telefono;
    private boolean estado;
    
    public Tienda(){
    }

    public Tienda(int idTienda, String nombre, String direccion, String telefono, boolean estado) {
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
