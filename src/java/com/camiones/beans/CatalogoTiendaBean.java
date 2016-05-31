/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camiones.beans;

import com.camiones.controlador.TiendaServicio;
import com.camiones.modelo.Tienda;
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
public class CatalogoTiendaBean  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private TiendaServicio tiendaServicio = new TiendaServicio();
    private List<Tienda> listaTiendas;
    private Tienda tiendaSeleccionada;
    private Tienda tiendaModal;
    private String valorBusqueda;
    
    
    /** Creates a new instance of CatalogoTiendaBean */
    public CatalogoTiendaBean() {
    }

    public TiendaServicio getTiendaServicio() {
        return tiendaServicio;
    }

    public void setTiendaServicio(TiendaServicio tiendaServicio) {
        this.tiendaServicio = tiendaServicio;
    }

    public List<Tienda> getListaTiendas() {
        return listaTiendas;
    }

    public void setListaTiendas(List<Tienda> listaTiendas) {
        this.listaTiendas = listaTiendas;
    }

    public Tienda getTiendaSeleccionada() {
        return tiendaSeleccionada;
    }

    public void setTiendaSeleccionada(Tienda tiendaSeleccionada) {
        this.tiendaSeleccionada = tiendaSeleccionada;
    }

    

    public Tienda getTiendaModal() {
        return tiendaModal;
    }

    public void setTiendaModal(Tienda tiendaModal) {
        this.tiendaModal = tiendaModal;
    }

    public String getValorBusqueda() {
        return valorBusqueda;
    }

    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }
    
    @PostConstruct
    public void inicializar(){
        this.listaTiendas = this.tiendaServicio.obtenerListaTiendas();
    }
    
    public void botonAceptar(){
        String mensaje = "";
        if(this.tiendaModal.getIdTienda() > 0){
            this.listaTiendas = this.tiendaServicio.editarTienda(this.tiendaModal);
            mensaje = "Información Editada";
        }else{
            this.listaTiendas = this.tiendaServicio.guardarTienda(this.tiendaModal);
            mensaje = "Información Guardada";
        }
       
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide()");
        addMessage(mensaje);
        
    }
    
    public void botonCerrar(){
        System.out.println("Modal Cerrada");
    }
    
    public void botonAgregar(){
        this.tiendaModal = new Tienda();
    } 
    
    public void botonEditar(){
        this.tiendaModal = this.tiendaSeleccionada;
    }
    
    public void busquedaTienda(){
        this.listaTiendas = this.tiendaServicio.obtenerTienda(this.valorBusqueda);
        String mensaje = (this.listaTiendas.size() > 0) ? "Información Encontrada" : "Información no Encontrada";
        addMessage(mensaje);
    
    }
    
       public void onRowSelect(SelectEvent event) {
        System.out.println("Seleccion Row Edit");
        this.tiendaModal = this.tiendaSeleccionada;

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
