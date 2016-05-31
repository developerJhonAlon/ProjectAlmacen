/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camiones.controlador;

import com.camiones.jpa.Conexion;
import com.camiones.modelo.Almacen;
import com.camiones.modelo.Camion;
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
public class CamionServicio implements Serializable {
     private static final long serialVersionUID = 1L;
     
     public CamionServicio(){
     }
     
     public List<Camion> editarCamion(Camion camion){
         Conexion cn = new Conexion();
         
         int confirma = cn.modificarCamion(camion);
         
         if(confirma != 1){
             System.out.println("AgregarExtension: Error Dato de Personal no guardado");     
         }else{
             List<Camion> camionEditado = new ArrayList<>();
             ResultSet res = cn.consultarPorIdCamion(camion.getIdCamion());
             try {
                while (res.next()) {
                    camionEditado.add(new Camion(res.getInt("CAM_ID"),
                            res.getString("CAM_MATRICULA"), res.getInt("CAM_MAX_VOLUMEN"),
                            res.getInt("CAM_MAX_PESO"), res.getBoolean("CAM_ESTADO")));
                }

            } catch (SQLException ex) {
                Logger.getLogger(CamionServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
             return camionEditado;
         }
         return null;
     }
     
     
    public List<Camion> guardarCamion(Camion camion) {
        Conexion cn = new Conexion();

        int confirma = cn.guardarCamion(camion);

        if (confirma != 1) {
            System.out.println("AgregarExtension: Error Dato de Personal no guardado");
        } else {
            List<Camion> camionEditado = new ArrayList<>();
            ResultSet res = cn.consultarListaCamiones();
            try {
               while (res.next()) {
                    camionEditado.add(new Camion(res.getInt("CAM_ID"),
                            res.getString("CAM_MATRICULA"), res.getInt("CAM_MAX_VOLUMEN"),
                            res.getInt("CAM_MAX_PESO"), res.getBoolean("CAM_ESTADO")));
                }


            } catch (SQLException ex) {
                Logger.getLogger(CamionServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return camionEditado;
        }
        return null;

    }
    
     public List<Camion> obtenerListaCamiones() {

        Conexion cn = new Conexion();
        ResultSet res = cn.consultarListaCamiones();
            List<Camion> camionesAll = new ArrayList<>();
        if (res == null) {
            System.out.println("No hay Información");
        } else {
            try {

                 while (res.next()) {
                    camionesAll.add(new Camion(res.getInt("CAM_ID"),
                            res.getString("CAM_MATRICULA"), res.getInt("CAM_MAX_VOLUMEN"),
                            res.getInt("CAM_MAX_PESO"), res.getBoolean("CAM_ESTADO")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CamionServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return camionesAll;
    }

     public List<Camion> obtenerCamion(String valorBusqueda) {

        Conexion cn = new Conexion();
        ResultSet res = cn.consultarCamion(valorBusqueda);
        List<Camion> camionesAll = new ArrayList<>();
        try {
                    while (res.next()) {
                    camionesAll.add(new Camion(res.getInt("CAM_ID"),
                            res.getString("CAM_MATRICULA"), res.getInt("CAM_MAX_VOLUMEN"),
                            res.getInt("CAM_MAX_PESO"), res.getBoolean("CAM_ESTADO")));
                }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return camionesAll;
    }
     
}
