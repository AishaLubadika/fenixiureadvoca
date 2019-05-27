/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUBADIKA
 */
@Entity
@Table(name = "advogado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advogado.findAll", query = "SELECT a FROM Advogado a")
    , @NamedQuery(name = "Advogado.findByIdAdvogado", query = "SELECT a FROM Advogado a WHERE a.idAdvogado = :idAdvogado")
    , @NamedQuery(name = "Advogado.findByNomeAdvogado", query = "SELECT a FROM Advogado a WHERE a.nomeAdvogado = :nomeAdvogado")
    , @NamedQuery(name = "Advogado.findByNumeroBiAdvogado", query = "SELECT a FROM Advogado a WHERE a.numeroBiAdvogado = :numeroBiAdvogado")
    , @NamedQuery(name = "Advogado.findByRuaAdvogado", query = "SELECT a FROM Advogado a WHERE a.ruaAdvogado = :ruaAdvogado")
    , @NamedQuery(name = "Advogado.findByBairroAdvogado", query = "SELECT a FROM Advogado a WHERE a.bairroAdvogado = :bairroAdvogado")
    , @NamedQuery(name = "Advogado.findByDataInicioFuncoes", query = "SELECT a FROM Advogado a WHERE a.dataInicioFuncoes = :dataInicioFuncoes")
    , @NamedQuery(name = "Advogado.findByTelefoneAdvogado", query = "SELECT a FROM Advogado a WHERE a.telefoneAdvogado = :telefoneAdvogado")
    , @NamedQuery(name = "Advogado.findByEmailAdvogado", query = "SELECT a FROM Advogado a WHERE a.emailAdvogado = :emailAdvogado")})
public class Advogado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
   
    @Column(name = "id_advogado")
    private Integer idAdvogado;
    @Size(max = 45)
    @Column(name = "nome_advogado")
    private String nomeAdvogado;
    @Size(max = 45)
    @Column(name = "numero_bi_advogado")
    private String numeroBiAdvogado;
    @Size(max = 45)
    @Column(name = "rua_advogado")
    private String ruaAdvogado;
    @Size(max = 45)
    @Column(name = "bairro_advogado")
    private String bairroAdvogado;
    @Column(name = "data_inicio_funcoes")
    @Temporal(TemporalType.DATE)
    private Date dataInicioFuncoes;
    @Size(max = 45)
    @Column(name = "telefone_advogado")
    private String telefoneAdvogado;
    @Size(max = 45)
    @Column(name = "email_advogado")
    private String emailAdvogado;
    @JoinColumn(name = "municipio", referencedColumnName = "id_municipio")
    @ManyToOne(optional = false)
    private Municipio municipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advogado")
    private Collection<Processo> processoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advogado")
    private Collection<Consulta> consultaCollection;

    public Advogado() {
    }

    public Advogado(Integer idAdvogado) {
        this.idAdvogado = idAdvogado;
    }

    public Integer getIdAdvogado() {
        return idAdvogado;
    }

    public void setIdAdvogado(Integer idAdvogado) {
        this.idAdvogado = idAdvogado;
    }

    public String getNomeAdvogado() {
        return nomeAdvogado;
    }

    public void setNomeAdvogado(String nomeAdvogado) {
        this.nomeAdvogado = nomeAdvogado;
    }

    public String getNumeroBiAdvogado() {
        return numeroBiAdvogado;
    }

    public void setNumeroBiAdvogado(String numeroBiAdvogado) {
        this.numeroBiAdvogado = numeroBiAdvogado;
    }

    public String getRuaAdvogado() {
        return ruaAdvogado;
    }

    public void setRuaAdvogado(String ruaAdvogado) {
        this.ruaAdvogado = ruaAdvogado;
    }

    public String getBairroAdvogado() {
        return bairroAdvogado;
    }

    public void setBairroAdvogado(String bairroAdvogado) {
        this.bairroAdvogado = bairroAdvogado;
    }

    public Date getDataInicioFuncoes() {
        return dataInicioFuncoes;
    }

    public void setDataInicioFuncoes(Date dataInicioFuncoes) {
        this.dataInicioFuncoes = dataInicioFuncoes;
    }

    public String getTelefoneAdvogado() {
        return telefoneAdvogado;
    }

    public void setTelefoneAdvogado(String telefoneAdvogado) {
        this.telefoneAdvogado = telefoneAdvogado;
    }

    public String getEmailAdvogado() {
        return emailAdvogado;
    }

    public void setEmailAdvogado(String emailAdvogado) {
        this.emailAdvogado = emailAdvogado;
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

    @XmlTransient
    public Collection<Consulta> getConsultaCollection() {
        return consultaCollection;
    }

    public void setConsultaCollection(Collection<Consulta> consultaCollection) {
        this.consultaCollection = consultaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdvogado != null ? idAdvogado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advogado)) {
            return false;
        }
        Advogado other = (Advogado) object;
        if ((this.idAdvogado == null && other.idAdvogado != null) || (this.idAdvogado != null && !this.idAdvogado.equals(other.idAdvogado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.Advogado[ idAdvogado=" + idAdvogado + " ]";
    }
    
}
