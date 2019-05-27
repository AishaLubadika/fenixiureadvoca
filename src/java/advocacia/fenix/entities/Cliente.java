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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM Cliente c WHERE c.nomeCliente = :nomeCliente")
    , @NamedQuery(name = "Cliente.findByApelidoCliente", query = "SELECT c FROM Cliente c WHERE c.apelidoCliente = :apelidoCliente")
    , @NamedQuery(name = "Cliente.findByNumeroBiCliente", query = "SELECT c FROM Cliente c WHERE c.numeroBiCliente = :numeroBiCliente")
    , @NamedQuery(name = "Cliente.findByBairroCliente", query = "SELECT c FROM Cliente c WHERE c.bairroCliente = :bairroCliente")
    , @NamedQuery(name = "Cliente.findByRuaCliente", query = "SELECT c FROM Cliente c WHERE c.ruaCliente = :ruaCliente")
    , @NamedQuery(name = "Cliente.findByTelefoneCliente", query = "SELECT c FROM Cliente c WHERE c.telefoneCliente = :telefoneCliente")
    , @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente")
    , @NamedQuery(name = "Cliente.findByObservacao", query = "SELECT c FROM Cliente c WHERE c.observacao = :observacao")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Size(max = 45)
    @Column(name = "nome_cliente")
    private String nomeCliente;
    @Size(max = 45)
    @Column(name = "apelido_cliente")
    private String apelidoCliente;
    @Size(max = 45)
    @Column(name = "numero_bi_cliente")
    private String numeroBiCliente;
    @Size(max = 45)
    @Column(name = "bairro_cliente")
    private String bairroCliente;
    @Size(max = 45)
    @Column(name = "rua_cliente")
    private String ruaCliente;
    @Size(max = 45)
    @Column(name = "telefone_cliente")
    private String telefoneCliente;
    @Size(max = 45)
    @Column(name = "email_cliente")
    private String emailCliente;
    @Size(max = 200)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "municipio", referencedColumnName = "id_municipio")
    @ManyToOne(optional = false)
    private Municipio municipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Processo> processoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Consulta> consultaCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getApelidoCliente() {
        return apelidoCliente;
    }

    public void setApelidoCliente(String apelidoCliente) {
        this.apelidoCliente = apelidoCliente;
    }

    public String getNumeroBiCliente() {
        return numeroBiCliente;
    }

    public void setNumeroBiCliente(String numeroBiCliente) {
        this.numeroBiCliente = numeroBiCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
