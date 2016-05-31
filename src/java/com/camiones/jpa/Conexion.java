/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camiones.jpa;

import com.camiones.modelo.Almacen;
import com.camiones.modelo.Camion;
import com.camiones.modelo.Tienda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonny
 */
public class Conexion {

    private Connection cnn; //Concxion la bd
    private Statement state; //ejecutar una query
    private ResultSet res; //guardar el resultado de un select

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //driver de conexion
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/camiones?zeroDateTimeBehavior=convertToNull", "root", "");  //url (utilzando JDBC en este caso), usuario, password
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
     * Metodo para obtener todos los Registro de Almacenes
     */
    public ResultSet consultarListaAlmacenes() {
        try {
            String query = "SELECT * FROM ALMACEN";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public ResultSet consultarAlmacen(String valorBusqueda) {
        try {
            String query = "SELECT * FROM ALMACEN WHERE ALM_DIRECCION LIKE'%" + valorBusqueda + "%' ORDER BY ALM_DIRECCION ASC";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public ResultSet consultarPorIdAlmacen(int idAlmacen) {
        try {
            String query = "SELECT * FROM ALMACEN WHERE ALM_ID=" + idAlmacen + "";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public int modificarAlmacen(Almacen almacen) {
        int conf = 0;
        String query = "UPDATE ALMACEN SET ALM_NUMERO="
                + almacen.getNumero() + ", ALM_DIRECCION='"
                + almacen.getDireccion() + "', ALM_TELEFONO='"
                + almacen.getTelefono() + "' , ALM_ESTADO="
                + almacen.isEstado() + " WHERE ALM_ID="
                + almacen.getIdAlmacen() + "";

        try {
            state = cnn.createStatement();
            conf = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf;
    }

    public int guardarAlmacen(Almacen almacen) {
        int conf = 0;
        String query = "INSERT INTO ALMACEN(ALM_NUMERO,ALM_DIRECCION,ALM_TELEFONO,ALM_ESTADO) values(" + almacen.getNumero() + ",'"
                + almacen.getDireccion() + "','" + almacen.getTelefono() + "'," + almacen.isEstado() + ")";

        try {
            state = cnn.createStatement();
            conf = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf;
    }
    
    /*
    *  Sql para la tabla Tienda
    */
    
    public ResultSet consultarListaTiendas() {
        try {
            String query = "SELECT * FROM TIENDA";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public int modificarTienda(Tienda tienda) {
        int conf = 0;
        String query = "UPDATE TIENDA SET TIE_NOMBRE='"
                + tienda.getNombre() + "', TIE_DIRECCION='"
                + tienda.getDireccion() + "', TIE_TELEFONO='"
                + tienda.getTelefono() + "' , TIE_ESTADO="
                + tienda.isEstado() + " WHERE TIE_ID="
                + tienda.getIdTienda() + "";

        try {
            state = cnn.createStatement();
            conf = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf;
    }
    
    
    public ResultSet consultarPorIdTienda(int idTienda) {
        try {
            String query = "SELECT * FROM TIENDA WHERE TIE_ID=" + idTienda + "";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public int guardarTienda(Tienda tienda) {
        int conf = 0;
        String query = "INSERT INTO TIENDA(TIE_NOMBRE,TIE_DIRECCION,TIE_TELEFONO,TIE_ESTADO) values('" + tienda.getNombre() + "','"
                + tienda.getDireccion() + "','" + tienda.getTelefono() + "'," + tienda.isEstado() + ")";

        try {
            state = cnn.createStatement();
            conf = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf;
    }
    
    
      public ResultSet consultarTienda(String valorBusqueda) {
        try {
            String query = "SELECT * FROM TIENDA WHERE TIE_NOMBRE LIKE'%" + valorBusqueda + "%' ORDER BY TIE_NOMBRE ASC";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
      
      /*
      * Camiones
      */
      
      public int modificarCamion(Camion camion) {
        int conf = 0;
        String query = "UPDATE CAMION SET CAM_MATRICULA='"
                + camion.getMatricula() + "', CAM_MAX_VOLUMEN="
                + camion.getMaxVolumen() + ", CAM_MAX_PESO="
                + camion.getMaxPeso() + " , CAM_ESTADO="
                + camion.isEstado() + " WHERE CAM_ID="
                + camion.getIdCamion() + "";

        try {
            state = cnn.createStatement();
            conf = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf;
    }

    public ResultSet consultarPorIdCamion(int idCamion) {
        try {
            String query = "SELECT * FROM CAMION WHERE CAM_ID=" + idCamion + "";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    
    public int guardarCamion(Camion camion) {
        int conf = 0;
        String query = "INSERT INTO CAMION(CAM_MATRICULA,CAM_MAX_VOLUMEN,CAM_MAX_PESO,CAM_ESTADO) values('" + camion.getMatricula() + "',"
                + camion.getMaxVolumen() + "," + camion.getMaxPeso() + "," + camion.isEstado() + ")";

        try {
            state = cnn.createStatement();
            conf = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf;
    }

    public ResultSet consultarListaCamiones() {
        try {
            String query = "SELECT * FROM CAMION";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public ResultSet consultarCamion(String valorBusqueda) {
        try {
            String query = "SELECT * FROM CAMION WHERE CAM_MATRICULA LIKE'%" + valorBusqueda + "%' ORDER BY CAM_MATRICULA ASC";

            state = cnn.createStatement();
            res = state.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
