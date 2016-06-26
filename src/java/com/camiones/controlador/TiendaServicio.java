/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camiones.controlador;

import com.camiones.jpa.Conexion;
import com.camiones.modelo.Tienda;
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
public class TiendaServicio implements Serializable {

    private static final long serialVersionUID = 1L;

    public TiendaServicio() {
    }
    
    public List<Tienda> obtenerListaTiendas(){
        Conexion cn = new Conexion();
        ResultSet res = cn.consultarListaTiendas();
        List<Tienda> tiendasAll = new ArrayList<>();
        
        if(res == null){
          System.out.println("No hay Información");
   
        }else{
            try {
                while(res.next()){
                    tiendasAll.add(new Tienda(res.getInt("TIE_ID"),res.getString("TIE_NOMBRE"),res.getString("TIE_DIRECCION"),res.getString("TIE_TELEFONO"),res.getBoolean("TIE_ESTADO")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TiendaServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tiendasAll;
        
    }

    public List<Tienda> editarTienda(Tienda tienda) {
        Conexion cn = new Conexion();

        int confirma = cn.modificarTienda(tienda);
        if (confirma != 1) {
            System.out.println("editarTienda: Error ");
        } else {
            List<Tienda> tiendaEditado = new ArrayList<>();
            ResultSet res = cn.consultarListaTiendas();

            try {
                while (res.next()) {
                    tiendaEditado.add(new Tienda(res.getInt("TIE_ID"), res.getString("TIE_NOMBRE"), res.getString("TIE_DIRECCION"), res.getString("TIE_TELEFONO"), res.getBoolean("TIE_ESTADO")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TiendaServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
           return tiendaEditado;
        }
        return null;
    }

    public List<Tienda> guardarTienda(Tienda tienda) {
        Conexion cn = new Conexion();
        int confirma = cn.guardarTienda(tienda);

        if (confirma != 1) {
            System.out.println("guardarTienda: Error");

        } else {
            List<Tienda> tiendaEditado = new ArrayList<>();
            ResultSet res = cn.consultarListaTiendas();

            try {
                while (res.next()) {
                    tiendaEditado.add(new Tienda(res.getInt("TIE_ID"), res.getString("TIE_NOMBRE"), res.getString("TIE_DIRECCION"), res.getString("TIE_TELEFONO"), res.getBoolean("TIE_ESTADO")));

                }
            } catch (SQLException ex) {
                Logger.getLogger(TiendaServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tiendaEditado;
        }
        return null;
    }

    public List<Tienda> obtenerTienda(String valorBusqueda){
         Conexion cn = new Conexion();
            ResultSet res = cn.consultarTienda(valorBusqueda);
            List<Tienda> tiendasAll = new ArrayList<>();
         
        
        try {
              while(res.next()){
                tiendasAll.add(new Tienda(res.getInt("TIE_ID"),res.getString("TIE_NOMBRE"),res.getString("TIE_DIRECCION"),res.getString("TIE_TELEFONO"),res.getBoolean("TIE_ESTADO")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiendaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiendasAll;
    }
}
