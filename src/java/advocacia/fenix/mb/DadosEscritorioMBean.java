/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.DadosEscritorioFacade;
import advocacia.fenix.entities.DadosEscritorio;
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
@Named(value = "dadosEscritorioMBean")
@SessionScoped
public class DadosEscritorioMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private DadosEscritorio dadosEscritorio;
     private List<DadosEscritorio> dados;
     
    public DadosEscritorioMBean() {
    }
    
    @Inject
    DadosEscritorioFacade dadosEscritorioFacade;
    
    @PostConstruct
    public void inicializar() {
        dadosEscritorio = new DadosEscritorio();
    }

    public DadosEscritorio getDadosEscritorio() {
        return dadosEscritorio;
    }

    public void setDadosEscritorio(DadosEscritorio dadosEscritorio) {
        this.dadosEscritorio = dadosEscritorio;
    }
    

    public List<DadosEscritorio> getDados() {
        dadosEscritorioFacade.findAll();
        return dados;
    }

    public void setDados(List<DadosEscritorio> dados) {
        this.dados = dados;
    }
    
    public void save(ActionEvent evt) {
        dadosEscritorioFacade.create(dadosEscritorio);

        dadosEscritorio = new DadosEscritorio();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "escritorio_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        dadosEscritorioFacade.edit(dadosEscritorio);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        dadosEscritorio = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("escritorio_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DadosEscritorioMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        dadosEscritorioFacade.remove(dadosEscritorio);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        dadosEscritorio = null;
        return "escritorio_listar?faces-redirect=true";
    }

   
    
}
