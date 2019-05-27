/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.DespesaProcessoFacade;
import advocacia.fenix.ejbs.ProcessoFacade;
import advocacia.fenix.entities.DespesaProcesso;
import advocacia.fenix.entities.Processo;
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
@Named(value = "despesaMBean")
@SessionScoped
public class DespesaMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private DespesaProcesso despesa;
    private Processo processo;

    private List<DespesaProcesso> despesas;
    private List<Processo> processos;

    public DespesaMBean() {
    }

    @Inject
    DespesaProcessoFacade despesaProcessoFacade;
    @Inject
    ProcessoFacade processoFacade;

    @PostConstruct
    public void inicializar() {
        despesa = new DespesaProcesso();
        processo = new Processo();

        despesas = new ArrayList<>();
        processos = new ArrayList<>();

    }

    public DespesaProcesso getDespesa() {
        return despesa;
    }

    public void setDespesa(DespesaProcesso despesa) {
        this.despesa = despesa;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public List<DespesaProcesso> getDespesas() {
        despesas= despesaProcessoFacade.findAll();
        return despesas;
    }

    public void setDespesas(List<DespesaProcesso> despesas) {
        this.despesas = despesas;
    }

    public List<Processo> getProcessos() {
        processos= processoFacade.findAll();
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }
    
     public void save(ActionEvent evt) {
        despesaProcessoFacade.create(despesa);

        despesa = new DespesaProcesso();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "despesa_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        despesaProcessoFacade.edit(despesa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        despesa = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("despesa_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DespesaMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

       despesaProcessoFacade.remove(despesa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        despesa = null;
        return "despesa_listar?faces-redirect=true";
    }
    

}
