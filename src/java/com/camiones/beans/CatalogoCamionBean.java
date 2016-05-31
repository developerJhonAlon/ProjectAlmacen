/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camiones.beans;

import com.camiones.controlador.CamionServicio;
import com.camiones.modelo.Camion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class CatalogoCamionBean implements Serializable{
    private static final long serialVersionUID = 1L;
      private CamionServicio camionServicio = new CamionServicio();
    private List<Camion> listaCamiones;
    private Camion camionSeleccionado;
    private Camion camionModal;
    private String valorBusqueda;
    
    /** Creates a new instance of CatalogoCamionBean */
    public CatalogoCamionBean() {
    }

    public CamionServicio getCamionServicio() {
        return camionServicio;
    }

    public void setCamionServicio(CamionServicio camionServicio) {
        this.camionServicio = camionServicio;
    }

    public List<Camion> getListaCamiones() {
        return listaCamiones;
    }

    public void setListaCamiones(List<Camion> listaCamiones) {
        this.listaCamiones = listaCamiones;
    }

    public Camion getCamionSeleccionado() {
        return camionSeleccionado;
    }

    public void setCamionSeleccionado(Camion camionSeleccionado) {
        this.camionSeleccionado = camionSeleccionado;
    }

    public Camion getCamionModal() {
        return camionModal;
    }

    public void setCamionModal(Camion camionModal) {
        this.camionModal = camionModal;
    }

    public String getValorBusqueda() {
        return valorBusqueda;
    }

    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }
    
    @PostConstruct
    public void inicializar(){
        this.listaCamiones = this.camionServicio.obtenerListaCamiones();
    }
    
     public void botonAceptar(){
        String mensaje = "";
        if(this.camionModal.getIdCamion() > 0){
             this.listaCamiones = this.camionServicio.editarCamion(this.camionModal);
             mensaje = "Información Editada";
        }else{
            this.listaCamiones = this.camionServicio.guardarCamion(this.camionModal);
            mensaje = "Información Guardada";
            
        }
      
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide()");
        addMessage(mensaje);
        
    }
     
     
      public void botonCerrar(){
        System.out.println("Modal Cerrada");
    }
      
        public void botonAgregar() {
        this.camionModal = new Camion();

    }
     
        
        public void botonEditar() {
        this.camionModal = this.camionSeleccionado;
    }
        
        public void busquedaCamion() {
        this.listaCamiones = this.camionServicio.obtenerCamion(this.valorBusqueda);

        String mensaje = (this.listaCamiones.size() > 0) ? "Información Encontrada"
                : "Información no Encontrada";
        addMessage(mensaje);
    }
        
 public void onRowSelect(SelectEvent event) {
        System.out.println("Seleccion Row Edit");
        this.camionModal = this.camionSeleccionado;

    }

    public void onRowUnselect(UnselectEvent event) {
        System.out.println("Seleccion Row Not ");

    }
    
    
    
     
      public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
