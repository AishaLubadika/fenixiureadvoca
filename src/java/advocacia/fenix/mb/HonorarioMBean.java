/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.HonorarioFacade;
import advocacia.fenix.ejbs.ProcessoFacade;
import advocacia.fenix.entities.Audiencia;
import advocacia.fenix.entities.Honorario;
import advocacia.fenix.entities.Processo;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author LUBADIKA
 */
@Named(value = "honorarioMBean")
@SessionScoped
public class HonorarioMBean implements Serializable{

      private static final long serialVersionUID = 1L;
      private Honorario honorario;
      private Processo processo;
      
      private List<Honorario> honorarios;
      private List<Processo> processos;
      
    public HonorarioMBean() {
    }
    
    @Inject
    HonorarioFacade honorarioFacade;
    @Inject
    ProcessoFacade processoFacade;
    
     @PostConstruct
    public void inicializar() {
        honorario = new Honorario();
        processo = new Processo();

        honorarios = new ArrayList<>();
        processos = new ArrayList<>();

    }

    public Honorario getHonorario() {
        return honorario;
    }

    public void setHonorario(Honorario honorario) {
        this.honorario = honorario;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public List<Honorario> getHonorarios() {
        honorarios= honorarioFacade.findAll();
        return honorarios;
    }

    public void setHonorarios(List<Honorario> honorarios) {
        this.honorarios = honorarios;
    }

    public List<Processo> getProcessos() {
        processos=processoFacade.findAll();
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }
    
     public void save(ActionEvent evt) {
        honorarioFacade.create(honorario);

        honorario = new Honorario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "honorario_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        honorarioFacade.edit(honorario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        honorario = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("honorario_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(HonorarioMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        honorarioFacade.remove(honorario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        honorario = null;
        return "honorario_listar?faces-redirect=true";
    }
    
}
