/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.TipoAudienciaFacade;
import advocacia.fenix.entities.TipoAudiencia;
import advocacia.fenix.entities.Usuario;
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
@Named(value = "tipoAudienciaMBean")
@SessionScoped
public class TipoAudienciaMBean implements Serializable {

     private static final long serialVersionUID = 1L;
     private TipoAudiencia tipoAudiencia;
     private List <TipoAudiencia> tipoAudiencias;
     
    public TipoAudienciaMBean() {
    }
    
    @Inject
    TipoAudienciaFacade tipoAudienciaFacade;
    
     @PostConstruct
    public void inicializar() {
        tipoAudiencia = new TipoAudiencia();
    }

    public TipoAudiencia getTipoAudiencia() {
        return tipoAudiencia;
    }

    public void setTipoAudiencia(TipoAudiencia tipoAudiencia) {
        this.tipoAudiencia = tipoAudiencia;
    }

    public List<TipoAudiencia> getTipoAudiencias() {
        
       tipoAudiencias= tipoAudienciaFacade.findAll();
        return tipoAudiencias;
    }

    public void setTipoAudiencias(List<TipoAudiencia> tipoAudiencias) {
        this.tipoAudiencias = tipoAudiencias;
    }
    
     public void save(ActionEvent evt) {
        tipoAudienciaFacade.create(tipoAudiencia);

        tipoAudiencia = new TipoAudiencia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "tipo_audiencia_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        tipoAudienciaFacade.edit(tipoAudiencia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        tipoAudiencia = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("tipo_audiencia_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TipoAudienciaMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        tipoAudienciaFacade.remove(tipoAudiencia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        tipoAudiencia = null;
        return "tipo_audiencia_listar?faces-redirect=true";
    }
    
}
