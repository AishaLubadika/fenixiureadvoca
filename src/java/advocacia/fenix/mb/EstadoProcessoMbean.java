/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.EstadoProcessoFacade;
import advocacia.fenix.entities.EstadoProcesso;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author LUBADIKA
 */
@Named(value = "estadoProcessoMbean")
@SessionScoped
public class EstadoProcessoMbean implements Serializable {

     private static final long serialVersionUID = 1L;
     private EstadoProcesso estadoProcesso;
     private List<EstadoProcesso> estadoProcessos;
     
    public EstadoProcessoMbean() {
    }
    
    @Inject
    EstadoProcessoFacade estadoProcessoFacade;
    
    @PostConstruct
    public void inicializar() {
        estadoProcesso = new EstadoProcesso();
    }

    public EstadoProcesso getEstadoProcesso() {
        return estadoProcesso;
    }

    public void setEstadoProcesso(EstadoProcesso estadoProcesso) {
        this.estadoProcesso = estadoProcesso;
    }

    public List<EstadoProcesso> getEstadoProcessos() {
        estadoProcessos= estadoProcessoFacade.findAll();
        return estadoProcessos;
    }

    public void setEstadoProcessos(List<EstadoProcesso> estadoProcessos) {
        this.estadoProcessos = estadoProcessos;
    }
    
    public void save(ActionEvent evt) {
        estadoProcessoFacade.create(estadoProcesso);

        estadoProcesso = new EstadoProcesso();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "estado_processo_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        estadoProcessoFacade.edit(estadoProcesso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        estadoProcesso = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("estado_processo_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(EstadoProcessoMbean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        estadoProcessoFacade.remove(estadoProcesso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        estadoProcesso = null;
        return "estado_processo_listar?faces-redirect=true";
    }

    
    
}
