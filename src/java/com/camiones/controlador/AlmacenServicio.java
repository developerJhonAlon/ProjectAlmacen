/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camiones.controlador;

import com.camiones.jpa.Conexion;
import com.camiones.modelo.Almacen;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonny
 */
public class AlmacenServicio implements Serializable {

    private static final long serialVersionUID = 1L;

    public AlmacenServicio() {

    }

    public List<Almacen> editarAlmacen(Almacen almacen) {
        Conexion cn = new Conexion();

        int confirma = cn.modificarAlmacen(almacen);

        if (confirma != 1) {
            System.out.println("editarAlmacen: Error ");
        } else {
            List<Almacen> almacenEditado = new ArrayList<>();
            ResultSet res = cn.consultarListaAlmacenes();
         try {
                while (res.next()) {
                    almacenEditado.add(new Almacen(res.getInt("ALM_ID"),
                            res.getInt("ALM_NUMERO"), res.getString("ALM_DIRECCION"),
                            res.getString("ALM_TELEFONO"), res.getBoolean("ALM_ESTADO")));
                }

            } catch (SQLException ex) {
                Logger.getLogger(AlmacenServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return almacenEditado;
        }
        return null;

    }

    public List<Almacen> guardarAlmacen(Almacen almacen) {
        Conexion cn = new Conexion();

        int confirma = cn.guardarAlmacen(almacen);

        if (confirma != 1) {
            System.out.println("guardarAlmcen: Error ");
        } else {
            List<Almacen> almacenEditado = new ArrayList<>();
            ResultSet res = cn.consultarListaAlmacenes();
            try {
                while (res.next()) {
                    almacenEditado.add(new Almacen(res.getInt("ALM_ID"),
                            res.getInt("ALM_NUMERO"), res.getString("ALM_DIRECCION"),
                            res.getString("ALM_TELEFONO"), res.getBoolean("ALM_ESTADO")));
                }

            } catch (SQLException ex) {
                Logger.getLogger(AlmacenServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return almacenEditado;
        }
        return null;

    }

    public List<Almacen> obtenerListaAlmacenes() {

        Conexion cn = new Conexion();
        ResultSet res = cn.consultarListaAlmacenes();
            List<Almacen> almacenesAll = new ArrayList<>();
        if (res == null) {
            System.out.println("No hay Información");
        } else {
            try {

                while (res.next()) {
                    almacenesAll.add(new Almacen(res.getInt("ALM_ID"),
                            res.getInt("ALM_NUMERO"), res.getString("ALM_DIRECCION"),
                            res.getString("ALM_TELEFONO"), res.getBoolean("ALM_ESTADO")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlmacenServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return almacenesAll;
    }

    public List<Almacen> obtenerAlmacen(String valorBusqueda) {

        Conexion cn = new Conexion();
        ResultSet res = cn.consultarAlmacen(valorBusqueda);
        List<Almacen> almacenesAll = new ArrayList<>();
        try {
            while (res.next()) {
                almacenesAll.add(new Almacen(res.getInt("ALM_ID"),
                        res.getInt("ALM_NUMERO"), res.getString("ALM_DIRECCION"),
                        res.getString("ALM_TELEFONO"), res.getBoolean("ALM_ESTADO")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return almacenesAll;
    }
}
