/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.MunicipioFacade;
import advocacia.fenix.ejbs.RequeridoFacade;
import advocacia.fenix.entities.Municipio;
import advocacia.fenix.entities.Requerido;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named(value = "requeridoMBean")
@SessionScoped
public class RequeridoMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Requerido requerido;
    private Municipio municipio;
    
    private List<Requerido> requeridos;
     private List<Municipio> municipios;

    public RequeridoMBean() {
    }

    @Inject
    RequeridoFacade requeridoFacade;
    @Inject
    MunicipioFacade municipiofacade;

    @PostConstruct
    public void inicializar() {
        requerido = new Requerido();
        municipio = new Municipio();
        
        requeridos =  new ArrayList<>();
        municipios= new ArrayList<>();
    }

    public Requerido getRequerido() {
        return requerido;
    }

    public void setRequerido(Requerido requerido) {
        this.requerido = requerido;
    }

    public List<Requerido> getRequeridos() {
        requeridos= requeridoFacade.findAll();
        return requeridos;
    }

    public void setRequeridos(List<Requerido> requeridos) {
        this.requeridos = requeridos;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Municipio> getMunicipios() {
        municipios= municipiofacade.findAll();
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
    
    
     public void save(ActionEvent evt) {
        requeridoFacade.create(requerido);

        requerido = new Requerido();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "requerido_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        requeridoFacade.edit(requerido);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado\t", "\tSucesso ao editar os dados"));

        requerido = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("requerido_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(RequeridoMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        requeridoFacade.remove(requerido);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletar\t", "\tSucesso ao deletar os dados"));
        requerido = null;
        return "requerido_listar?faces-redirect=true";
    }

}
