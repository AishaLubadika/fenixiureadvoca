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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUBADIKA
 */
@Entity
@Table(name = "tipo_processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProcesso.findAll", query = "SELECT t FROM TipoProcesso t")
    , @NamedQuery(name = "TipoProcesso.findByIdTipoProcesso", query = "SELECT t FROM TipoProcesso t WHERE t.idTipoProcesso = :idTipoProcesso")
    , @NamedQuery(name = "TipoProcesso.findByTipoProcesso", query = "SELECT t FROM TipoProcesso t WHERE t.tipoProcesso = :tipoProcesso")})
public class TipoProcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_processo")
    private Integer idTipoProcesso;
    @Size(max = 45)
    @Column(name = "tipo_processo")
    private String tipoProcesso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProcesso")
    private Collection<Processo> processoCollection;

    public TipoProcesso() {
    }

    public TipoProcesso(Integer idTipoProcesso) {
        this.idTipoProcesso = idTipoProcesso;
    }

    public Integer getIdTipoProcesso() {
        return idTipoProcesso;
    }

    public void setIdTipoProcesso(Integer idTipoProcesso) {
        this.idTipoProcesso = idTipoProcesso;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
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
        hash += (idTipoProcesso != null ? idTipoProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProcesso)) {
            return false;
        }
        TipoProcesso other = (TipoProcesso) object;
        if ((this.idTipoProcesso == null && other.idTipoProcesso != null) || (this.idTipoProcesso != null && !this.idTipoProcesso.equals(other.idTipoProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.TipoProcesso[ idTipoProcesso=" + idTipoProcesso + " ]";
    }
    
}
