/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.AdvogadoFacade;
import advocacia.fenix.ejbs.MunicipioFacade;
import advocacia.fenix.ejbs.ProvinciaFacade;
import advocacia.fenix.entities.Advogado;
import advocacia.fenix.entities.Municipio;
import advocacia.fenix.entities.Provincia;
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
@Named(value = "advogadoMBean")
@SessionScoped
public class AdvogadoMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Advogado advogado;
    private Municipio municipio;
    private Provincia provincia;

    private List<Advogado> advogados;
    private List<Municipio> municipios;
    private List<Provincia> provincias;

    public AdvogadoMBean() {
    }

    @Inject
    AdvogadoFacade advogadoFacade;
    @Inject
    MunicipioFacade municipioFacade;
    @Inject
    ProvinciaFacade provinciaFacade;

    @PostConstruct
    public void inicializar() {
        advogado = new Advogado();
        municipio = new Municipio();
        provincia = new Provincia();
        municipios = new ArrayList<>();
        provincias = new ArrayList<>();
        advogados= new ArrayList<>();

    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Municipio> getMunicipios() {
        municipios = municipioFacade.findAll();
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public List<Provincia> getProvincias() {
        provincias = provinciaFacade.findAll();
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    //ainda em analise talvz tem que criar uma consulta pra encontrar o ID
    public void carregaMunicipiosDaProvincia() {
        municipios = (List<Municipio>) municipioFacade.find(provincia);
    }
    
    
    public List<Advogado> getAdvogados() {
        advogados = advogadoFacade.findAll();
        return advogados;
    }

    public void setAdvogados(List<Advogado> advogados) {
        this.advogados = advogados;
    }

    public void save(ActionEvent evt) {
        advogadoFacade.create(advogado);

        advogado = new Advogado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "advogado_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        advogadoFacade.edit(advogado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        advogado = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("advogado_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(AdvogadoMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        advogadoFacade.remove(advogado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        advogado = null;
        return "advogado_listar?faces-redirect=true";
    }

}
