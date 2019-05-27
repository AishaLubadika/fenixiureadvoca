/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUBADIKA
 */
@Entity
@Table(name = "requerido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requerido.findAll", query = "SELECT r FROM Requerido r")
    , @NamedQuery(name = "Requerido.findByIdRequerido", query = "SELECT r FROM Requerido r WHERE r.idRequerido = :idRequerido")
    , @NamedQuery(name = "Requerido.findByNomeRequerido", query = "SELECT r FROM Requerido r WHERE r.nomeRequerido = :nomeRequerido")
    , @NamedQuery(name = "Requerido.findByApelidoRequerido", query = "SELECT r FROM Requerido r WHERE r.apelidoRequerido = :apelidoRequerido")
    , @NamedQuery(name = "Requerido.findByNumeroBiRequerido", query = "SELECT r FROM Requerido r WHERE r.numeroBiRequerido = :numeroBiRequerido")
    , @NamedQuery(name = "Requerido.findByBairroRequerido", query = "SELECT r FROM Requerido r WHERE r.bairroRequerido = :bairroRequerido")
    , @NamedQuery(name = "Requerido.findByRuaRequerido", query = "SELECT r FROM Requerido r WHERE r.ruaRequerido = :ruaRequerido")
    , @NamedQuery(name = "Requerido.findByTelefoneRequerido", query = "SELECT r FROM Requerido r WHERE r.telefoneRequerido = :telefoneRequerido")
    , @NamedQuery(name = "Requerido.findByEmailRequerido", query = "SELECT r FROM Requerido r WHERE r.emailRequerido = :emailRequerido")
    , @NamedQuery(name = "Requerido.findByObservacao", query = "SELECT r FROM Requerido r WHERE r.observacao = :observacao")})
public class Requerido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "id_requerido")
    private Integer idRequerido;
    @Size(max = 45)
    @Column(name = "nome_requerido")
    private String nomeRequerido;
    @Size(max = 45)
    @Column(name = "apelido_requerido")
    private String apelidoRequerido;
    @Size(max = 45)
    @Column(name = "numero_bi_requerido")
    private String numeroBiRequerido;
    @Size(max = 45)
    @Column(name = "bairro_requerido")
    private String bairroRequerido;
    @Size(max = 45)
    @Column(name = "rua_requerido")
    private String ruaRequerido;
    @Size(max = 45)
    @Column(name = "telefone_requerido")
    private String telefoneRequerido;
    @Size(max = 45)
    @Column(name = "email_requerido")
    private String emailRequerido;
    @Size(max = 200)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "municipio", referencedColumnName = "id_municipio")
    @ManyToOne(optional = false)
    private Municipio municipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requerido")
    private Collection<Processo> processoCollection;

    public Requerido() {
    }

    public Requerido(Integer idRequerido) {
        this.idRequerido = idRequerido;
    }

    public Integer getIdRequerido() {
        return idRequerido;
    }

    public void setIdRequerido(Integer idRequerido) {
        this.idRequerido = idRequerido;
    }

    public String getNomeRequerido() {
        return nomeRequerido;
    }

    public void setNomeRequerido(String nomeRequerido) {
        this.nomeRequerido = nomeRequerido;
    }

    public String getApelidoRequerido() {
        return apelidoRequerido;
    }

    public void setApelidoRequerido(String apelidoRequerido) {
        this.apelidoRequerido = apelidoRequerido;
    }

    public String getNumeroBiRequerido() {
        return numeroBiRequerido;
    }

    public void setNumeroBiRequerido(String numeroBiRequerido) {
        this.numeroBiRequerido = numeroBiRequerido;
    }

    public String getBairroRequerido() {
        return bairroRequerido;
    }

    public void setBairroRequerido(String bairroRequerido) {
        this.bairroRequerido = bairroRequerido;
    }

    public String getRuaRequerido() {
        return ruaRequerido;
    }

    public void setRuaRequerido(String ruaRequerido) {
        this.ruaRequerido = ruaRequerido;
    }

    public String getTelefoneRequerido() {
        return telefoneRequerido;
    }

    public void setTelefoneRequerido(String telefoneRequerido) {
        this.telefoneRequerido = telefoneRequerido;
    }

    public String getEmailRequerido() {
        return emailRequerido;
    }

    public void setEmailRequerido(String emailRequerido) {
        this.emailRequerido = emailRequerido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @XmlTransient
    public Collection<Processo> getProcessoCollection() {
        return processoCollection;
    }

    public void setProcessoCollection(Collection<Processo> processoCollection) {
        this.processoCollection = processoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequerido != null ? idRequerido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerido)) {
            return false;
        }
        Requerido other = (Requerido) object;
        if ((this.idRequerido == null && other.idRequerido != null) || (this.idRequerido != null && !this.idRequerido.equals(other.idRequerido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.Requerido[ idRequerido=" + idRequerido + " ]";
    }
    
}
