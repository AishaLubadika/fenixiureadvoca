/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.AdvogadoFacade;
import advocacia.fenix.ejbs.ClienteFacade;
import advocacia.fenix.ejbs.EstadoProcessoFacade;
import advocacia.fenix.ejbs.ProcessoFacade;
import advocacia.fenix.ejbs.RequeridoFacade;
import advocacia.fenix.ejbs.TipoDecisaoFacade;
import advocacia.fenix.ejbs.TipoProcessoFacade;
import advocacia.fenix.entities.Advogado;
import advocacia.fenix.entities.Cliente;
import advocacia.fenix.entities.EstadoProcesso;
import advocacia.fenix.entities.Processo;
import advocacia.fenix.entities.Requerido;
import advocacia.fenix.entities.TipoDecisao;
import advocacia.fenix.entities.TipoProcesso;
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
@Named(value = "processoMBean")
@SessionScoped
public class ProcessoMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Processo processo;
    private Advogado advogado;
    private Cliente cliente;
    private Requerido requerido;
    private EstadoProcesso estadoProcesso;
    private TipoProcesso tipoProcesso;
    private TipoDecisao tipoDecisao;

    private List<Processo> processos;
    private List<Cliente> clientes;
    private List<Advogado> advogados;
    private List<Requerido> requeridos;
    private List<EstadoProcesso> estadoProcessos;
    private List<TipoDecisao> tipoDecisaos;
    private List<TipoProcesso> tipoProcessos;

    public ProcessoMBean() {
    }

    @Inject
    ProcessoFacade processoFacade;
    @Inject
    ClienteFacade clienteFacade;
    @Inject
    RequeridoFacade requeridoFacade;
    @Inject
    EstadoProcessoFacade estadoProcessoFacade;
    @Inject
    TipoDecisaoFacade tipoDecisaoFacade;
    @Inject
    TipoProcessoFacade tipoProcessoFacade;
    @Inject
    AdvogadoFacade advogadoFacade;
    @PostConstruct
    public void inicializar() {
        processo = new Processo();
        advogado= new Advogado();
        cliente = new Cliente();
        requerido = new Requerido();
        tipoDecisao = new TipoDecisao();
        tipoProcesso = new TipoProcesso();
        estadoProcesso = new EstadoProcesso();

        processos = new ArrayList<>();
        clientes = new ArrayList<>();
        advogados = new ArrayList<>();
        requeridos = new ArrayList<>();
        tipoDecisaos = new ArrayList<>();
        tipoProcessos = new ArrayList<>();
        estadoProcessos = new ArrayList<>();

    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Requerido getRequerido() {
        return requerido;
    }

    public void setRequerido(Requerido requerido) {
        this.requerido = requerido;
    }

    public EstadoProcesso getEstadoProcesso() {
        return estadoProcesso;
    }

    public void setEstadoProcesso(EstadoProcesso estadoProcesso) {
        this.estadoProcesso = estadoProcesso;
    }

    public TipoProcesso getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(TipoProcesso tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public TipoDecisao getTipoDecisao() {
        return tipoDecisao;
    }

    public void setTipoDecisao(TipoDecisao tipoDecisao) {
        this.tipoDecisao = tipoDecisao;
    }

    public List<Processo> getProcessos() {
        processos= processoFacade.findAll();
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    public List<Cliente> getClientes() {
        clientes= clienteFacade.findAll();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Requerido> getRequeridos() {
        requeridos= requeridoFacade.findAll();
        return requeridos;
    }

    public void setRequeridos(List<Requerido> requeridos) {
        this.requeridos = requeridos;
    }

    public List<EstadoProcesso> getEstadoProcessos() {
        estadoProcessos= estadoProcessoFacade.findAll();
        return estadoProcessos;
    }

    public void setEstadoProcessos(List<EstadoProcesso> estadoProcessos) {
        this.estadoProcessos = estadoProcessos;
    }

    public List<TipoDecisao> getTipoDecisaos() {
        tipoDecisaos= tipoDecisaoFacade.findAll();
        return tipoDecisaos;
    }

    public void setTipoDecisaos(List<TipoDecisao> tipoDecisaos) {
        this.tipoDecisaos = tipoDecisaos;
    }

    public List<TipoProcesso> getTipoProcessos() {
        tipoProcessos= tipoProcessoFacade.findAll();           
        return tipoProcessos;
    }

    public void setTipoProcessos(List<TipoProcesso> tipoProcessos) {
        this.tipoProcessos = tipoProcessos;
    }

    public List<Advogado> getAdvogados() {
        advogados= advogadoFacade.findAll();
        return advogados;
    }

    public void setAdvogados(List<Advogado> advogados) {
        this.advogados = advogados;
    }
    
    
    
    public void save(ActionEvent evt) {
        processoFacade.create(processo);

        processo = new Processo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "processo_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        processoFacade.edit(processo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        processo = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("processo_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ProcessoMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        processoFacade.remove(processo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        processo = null;
        return "processo_listar?faces-redirect=true";
    }
    
}
