/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.AdvogadoFacade;
import advocacia.fenix.ejbs.ClienteFacade;
import advocacia.fenix.ejbs.ConsultaFacade;
import advocacia.fenix.entities.Advogado;
import advocacia.fenix.entities.Cliente;
import advocacia.fenix.entities.Consulta;
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
@Named(value = "consultaMBean")
@SessionScoped
public class ConsultaMBean implements Serializable{
   private static final long serialVersionUID = 1L;
    private  Consulta consulta;
    private Cliente cliente;
    private Advogado advogado;
    
     private List<Consulta> consultas;
     private List<Cliente> clientes;
     private List<Advogado> advogados;
   
    public ConsultaMBean() {
    }
    
    @Inject
    ConsultaFacade consultaFacade;
    @Inject
    ClienteFacade clienteFacace;
    @Inject
    AdvogadoFacade advogadoFacade;
    
    @PostConstruct
    public void inicializar() {
    consulta = new Consulta();
    cliente = new Cliente();
    advogado= new Advogado();
    
    consultas = new ArrayList<>();
    clientes = new ArrayList<>();
    advogados = new ArrayList<>();
    
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public List<Consulta> getConsultas() {
        consultas = consultaFacade.findAll();
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Cliente> getClientes() {
        clientes= clienteFacace.findAll();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Advogado> getAdvogados() {
        advogados= advogadoFacade.findAll();
        return advogados;
    }

    public void setAdvogados(List<Advogado> advogados) {
        this.advogados = advogados;
    }
    
    public void save(ActionEvent evt) {
        consultaFacade.create(consulta);

        consulta = new Consulta();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "consulta_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        consultaFacade.edit(consulta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        consulta = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("consulta_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ConsultaMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        consultaFacade.remove(consulta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        consulta = null;
        return "consulta_listar?faces-redirect=true";
    }

    
    
}
