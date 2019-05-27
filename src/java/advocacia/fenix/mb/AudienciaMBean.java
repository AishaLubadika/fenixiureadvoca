/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.AudienciaFacade;
import advocacia.fenix.ejbs.ProcessoFacade;
import advocacia.fenix.ejbs.TipoAudienciaFacade;
import advocacia.fenix.entities.Audiencia;
import advocacia.fenix.entities.Processo;
import advocacia.fenix.entities.TipoAudiencia;
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
@Named(value = "audienciaMBean")
@SessionScoped
public class AudienciaMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Audiencia audiencia;
    private Processo processo;
    private TipoAudiencia tipoAudiencia;

    private List<Audiencia> audiencias;
    private List<Processo> processos;
     private List<TipoAudiencia> tipos;

    public AudienciaMBean() {
    }

    @Inject
    AudienciaFacade audienciaFacade;
    @Inject
    ProcessoFacade processoFacade;
    @Inject
     TipoAudienciaFacade tipoAudienciaFacade;

    @PostConstruct
    public void inicializar() {
        audiencia = new Audiencia();
        processo = new Processo();
        tipoAudiencia= new TipoAudiencia();

        audiencias = new ArrayList<>();
        processos = new ArrayList<>();
        tipos= new ArrayList<>();

    }

    public Audiencia getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(Audiencia audiencia) {
        this.audiencia = audiencia;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public List<Audiencia> getAudiencias() {
        audiencias= audienciaFacade.findAll();
        return audiencias;
    }

    public void setAudiencias(List<Audiencia> audiencias) {
        this.audiencias = audiencias;
    }

    public List<Processo> getProcessos() {
        processos= processoFacade.findAll();
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    public TipoAudiencia getTipoAudiencia() {
        return tipoAudiencia;
    }

    public void setTipoAudiencia(TipoAudiencia tipoAudiencia) {
        this.tipoAudiencia = tipoAudiencia;
    }

    public List<TipoAudiencia> getTipos() {
        tipos= tipoAudienciaFacade.findAll();
        return tipos;
    }

    public void setTipos(List<TipoAudiencia> tipos) {
        this.tipos = tipos;
    }
    
    
    public void save(ActionEvent evt) {
        audienciaFacade.create(audiencia);

        audiencia = new Audiencia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "audiencia_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        audienciaFacade.edit(audiencia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        audiencia = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("audiencia_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(AudienciaMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        audienciaFacade.remove(audiencia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        audiencia = null;
        return "audiencia_listar?faces-redirect=true";
    }

    

}
