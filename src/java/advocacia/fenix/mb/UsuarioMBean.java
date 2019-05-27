/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.mb;

import advocacia.fenix.ejbs.UsuarioFacade;
import advocacia.fenix.entities.Usuario;
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
@Named(value = "usuarioMBean")
@SessionScoped
public class UsuarioMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private List<Usuario> usuarios;

    public UsuarioMBean() {
    }

    @Inject
    UsuarioFacade usuarioFacade;

    @PostConstruct
    public void inicializar() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        usuarios = usuarioFacade.findAll();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void save(ActionEvent evt) {
        usuarioFacade.create(usuario);

        usuario = new Usuario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "usuario_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        usuarioFacade.edit(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        usuario = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("usuario_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(UsuarioMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        usuarioFacade.remove(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        usuario = null;
        return "usuario_listar?faces-redirect=true";
    }

}
