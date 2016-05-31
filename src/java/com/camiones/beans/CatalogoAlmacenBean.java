/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camiones.beans;

import com.camiones.controlador.AlmacenServicio;
import com.camiones.modelo.Almacen;
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
public class CatalogoAlmacenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AlmacenServicio almacenServicio = new AlmacenServicio();
    private List<Almacen> listaAlmacenes;
    private Almacen almacenSeleccionado;
    private Almacen almacenModal;
    private String valorBusqueda;

    /** Creates a new instance of CatalogoAlmacenBean */
    public CatalogoAlmacenBean() {
    }

    public Almacen getAlmacenSeleccionado() {
        return almacenSeleccionado;
    }

    public void setAlmacenSeleccionado(Almacen almacenSeleccionado) {
        this.almacenSeleccionado = almacenSeleccionado;
    }

    public AlmacenServicio getAlmacenServicio() {
        return almacenServicio;
    }

    public void setAlmacenServicio(AlmacenServicio almacenServicio) {
        this.almacenServicio = almacenServicio;
    }

    public List<Almacen> getListaAlmacenes() {
        return listaAlmacenes;
    }

    public void setListaAlmacenes(List<Almacen> listaAlmacenes) {
        this.listaAlmacenes = listaAlmacenes;
    }

   

    public Almacen getAlmacenModal() {
        return almacenModal;
    }

    public void setAlmacenModal(Almacen almacenModal) {
        this.almacenModal = almacenModal;
    }

    public String getValorBusqueda() {
        return valorBusqueda;
    }

    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }

    @PostConstruct
    public void inicializar() {
        this.listaAlmacenes = this.almacenServicio.obtenerListaAlmacenes();
    }

    
    public void botonAceptar(){
        String mensaje = "";
        if(this.almacenModal.getIdAlmacen() > 0){
             this.listaAlmacenes = this.almacenServicio.editarAlmacen(this.almacenModal);
             mensaje = "Información Editada";
        }else{
            this.listaAlmacenes = this.almacenServicio.guardarAlmacen(this.almacenModal);
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
        this.almacenModal = new Almacen();

    }

    public void botonEditar() {
        this.almacenModal = this.almacenSeleccionado;
    }

    public void busquedaAlmacen() {
        this.listaAlmacenes = this.almacenServicio.obtenerAlmacen(this.valorBusqueda);

        String mensaje = (this.listaAlmacenes.size() > 0) ? "Información Encontrada"
                : "Información no Encontrada";
        addMessage(mensaje);
    }

    public void onRowSelect(SelectEvent event) {
        System.out.println("Seleccion Row Edit");
        this.almacenModal = this.almacenSeleccionado;

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
