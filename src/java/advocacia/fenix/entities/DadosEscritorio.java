/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUBADIKA
 */
@Entity
@Table(name = "dados_escritorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DadosEscritorio.findAll", query = "SELECT d FROM DadosEscritorio d")
    , @NamedQuery(name = "DadosEscritorio.findByIdEscritorio", query = "SELECT d FROM DadosEscritorio d WHERE d.idEscritorio = :idEscritorio")
    , @NamedQuery(name = "DadosEscritorio.findByNomeEscritorio", query = "SELECT d FROM DadosEscritorio d WHERE d.nomeEscritorio = :nomeEscritorio")
    , @NamedQuery(name = "DadosEscritorio.findByNifEscritorio", query = "SELECT d FROM DadosEscritorio d WHERE d.nifEscritorio = :nifEscritorio")
    , @NamedQuery(name = "DadosEscritorio.findByBairroEscritorio", query = "SELECT d FROM DadosEscritorio d WHERE d.bairroEscritorio = :bairroEscritorio")
    , @NamedQuery(name = "DadosEscritorio.findByTelefoneEscritorio", query = "SELECT d FROM DadosEscritorio d WHERE d.telefoneEscritorio = :telefoneEscritorio")
    , @NamedQuery(name = "DadosEscritorio.findByEmailEscritorio", query = "SELECT d FROM DadosEscritorio d WHERE d.emailEscritorio = :emailEscritorio")})
public class DadosEscritorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_escritorio")
    private Integer idEscritorio;
    @Size(max = 45)
    @Column(name = "nome_escritorio")
    private String nomeEscritorio;
    @Size(max = 45)
    @Column(name = "nif_escritorio")
    private String nifEscritorio;
    @Size(max = 45)
    @Column(name = "bairro_escritorio")
    private String bairroEscritorio;
    @Size(max = 45)
    @Column(name = "telefone_escritorio")
    private String telefoneEscritorio;
    @Size(max = 45)
    @Column(name = "email_escritorio")
    private String emailEscritorio;

    public DadosEscritorio() {
    }

    public DadosEscritorio(Integer idEscritorio) {
        this.idEscritorio = idEscritorio;
    }

    public Integer getIdEscritorio() {
        return idEscritorio;
    }

    public void setIdEscritorio(Integer idEscritorio) {
        this.idEscritorio = idEscritorio;
    }

    public String getNomeEscritorio() {
        return nomeEscritorio;
    }

    public void setNomeEscritorio(String nomeEscritorio) {
        this.nomeEscritorio = nomeEscritorio;
    }

    public String getNifEscritorio() {
        return nifEscritorio;
    }

    public void setNifEscritorio(String nifEscritorio) {
        this.nifEscritorio = nifEscritorio;
    }

    public String getBairroEscritorio() {
        return bairroEscritorio;
    }

    public void setBairroEscritorio(String bairroEscritorio) {
        this.bairroEscritorio = bairroEscritorio;
    }

    public String getTelefoneEscritorio() {
        return telefoneEscritorio;
    }

    public void setTelefoneEscritorio(String telefoneEscritorio) {
        this.telefoneEscritorio = telefoneEscritorio;
    }

    public String getEmailEscritorio() {
        return emailEscritorio;
    }

    public void setEmailEscritorio(String emailEscritorio) {
        this.emailEscritorio = emailEscritorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscritorio != null ? idEscritorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DadosEscritorio)) {
            return false;
        }
        DadosEscritorio other = (DadosEscritorio) object;
        if ((this.idEscritorio == null && other.idEscritorio != null) || (this.idEscritorio != null && !this.idEscritorio.equals(other.idEscritorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.DadosEscritorio[ idEscritorio=" + idEscritorio + " ]";
    }
    
}
