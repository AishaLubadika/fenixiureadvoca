/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.ClienteFacade;
import advocacia.fenix.ejbs.MunicipioFacade;
import advocacia.fenix.entities.Cliente;
import advocacia.fenix.entities.Municipio;
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
@Named(value = "clienteMBean")
@SessionScoped
public class ClienteMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    //variaveos de pesquisa
    private String nome;
    private String sobrenome;

    private Cliente cliente;
    private Municipio municipio;

    private List<Cliente> clientes;
    private List<Municipio> municipios;
    private List<Cliente> findByNome;
    private List<Cliente> findBySobrenome;
    private List<Cliente> findByNomeSobrenome;

    public ClienteMBean() {
    }

    @Inject
    ClienteFacade clienteFacade;
    @Inject
    MunicipioFacade municipioFacade;

    @PostConstruct
    public void inicializar() {
        cliente = new Cliente();
        municipio = new Municipio();
        clientes = new ArrayList<>();
        municipios = new ArrayList<>();
        findByNome = new ArrayList<>();
        findBySobrenome=new ArrayList<>();
        findByNomeSobrenome=new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        clientes = clienteFacade.findAll();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Municipio> getMunicipios() {
        municipios = municipioFacade.findAll();
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cliente> getFindByNome() {
        return findByNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Cliente> getFindBySobrenome() {
        return findBySobrenome;
    }

    public void setFindBySobrenome(List<Cliente> findBySobrenome) {
        this.findBySobrenome = findBySobrenome;
    }

    public List<Cliente> getFindByNomeSobrenome() {
        return findByNomeSobrenome;
    }

    public void setFindByNomeSobrenome(List<Cliente> findByNomeSobrenome) {
        this.findByNomeSobrenome = findByNomeSobrenome;
    }
    

    public void setFindByNome(List<Cliente> findByNome) {
        this.findByNome = findByNome;
    }

    public void save(ActionEvent evt) {
        clienteFacade.create(cliente);

        cliente = new Cliente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "cliente_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        clienteFacade.edit(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        cliente = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cliente_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ClienteMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        clienteFacade.remove(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        cliente = null;
        return "cliente_listar?faces-redirect=true";
    }

    public List<Cliente> getByNomeSobrenome() {

        if ((getNome() == null || getNome().isEmpty()) && (getSobrenome() == null)) {
            return null;

        } else if (((getSobrenome() == null) || (getSobrenome().isEmpty())) && ((getNome() != null || !getNome().isEmpty()))) {
            findByNome = clienteFacade.findByNome(nome);
            return findByNome;
        } else if ((getNome() == null || getNome().isEmpty() && getSobrenome() != null)) {
            findBySobrenome = clienteFacade.findBySobrenome(sobrenome);
            return findBySobrenome;
        } else if ((getNome() != null || !getNome().isEmpty()) && (getSobrenome() != null || !getSobrenome().isEmpty())) {
            findByNomeSobrenome = clienteFacade.findByNomeSobrenome(nome, sobrenome);
            return findByNomeSobrenome;
        }
        return null;
    }

}
