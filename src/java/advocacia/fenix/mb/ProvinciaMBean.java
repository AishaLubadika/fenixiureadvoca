/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.ProvinciaFacade;
import advocacia.fenix.entities.Provincia;
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
@Named(value = "provinciaMBean")
@SessionScoped
public class ProvinciaMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Provincia provincia;
    private List<Provincia> provincias;

    public ProvinciaMBean() {
    }

    @Inject
    ProvinciaFacade provinciaFacade;
    
   @PostConstruct
    public void inicializar() {
        provincia = new Provincia();
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Provincia> getProvincias() {
        provincias= provinciaFacade.findAll();
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
    
    public void save(ActionEvent evt) {
        provinciaFacade.create(provincia);

        provincia = new Provincia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "provincia_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        provinciaFacade.edit(provincia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        provincia = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("provincia_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ProvinciaMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        provinciaFacade.remove(provincia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        provincia = null;
        return "provincia_listar?faces-redirect=true";
    }

    
    


}
