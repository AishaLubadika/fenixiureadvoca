/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.MunicipioFacade;
import advocacia.fenix.ejbs.ProvinciaFacade;
import advocacia.fenix.entities.Municipio;
import advocacia.fenix.entities.Provincia;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

/**
 *
 * @author LUBADIKA
 */
@Named(value = "municipioMBean")
@SessionScoped
public class MunicipioMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Municipio municipio;
    private Provincia provincia;

    private List<Municipio> municipios;
    private List<Provincia> provincias;

    public MunicipioMBean() {

    }

    @Inject
    MunicipioFacade municipioFacade;
    ProvinciaFacade provinciaFacade;
    
    @PostConstruct
    public void init() {
       municipio= new Municipio();
       provincia = new Provincia();
        
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
        //municipios= municipioFacade.findAll();
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public List<Provincia> getProvincias() {
        //provincias= provinciaFacade.findAll();
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
    
    public void loadMunicipios() {
        municipios = (List<Municipio>) municipioFacade.find(provincia);
    }
    
     public void carregaMunicipiosDaProvincia(ValueChangeEvent event) {
        Provincia p = (Provincia) event.getNewValue();
        Integer id = p.getIdProvincia();
        System.out.print("Sigla>>>>>>" + event.getNewValue().toString());
        municipios = (List<Municipio>) municipioFacade.find(id);

    }
     /**
     *
     * @param event - carrega os municipios da proncia seleccionada
     */
      public void listaMunicipiosDaProvincia(AjaxBehaviorEvent event) {

        String dueDate = (String) ((UIOutput) event.getSource()).getValue();

        System.out.println("Provincia <<<<<=====" + dueDate);
        //municipios = municipioDAO.findByIdProvincia(provincia);
    }

}
