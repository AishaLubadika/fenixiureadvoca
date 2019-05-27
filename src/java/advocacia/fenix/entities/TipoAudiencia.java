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
@Table(name = "tipo_audiencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAudiencia.findAll", query = "SELECT t FROM TipoAudiencia t")
    , @NamedQuery(name = "TipoAudiencia.findByIdTipoAudiencia", query = "SELECT t FROM TipoAudiencia t WHERE t.idTipoAudiencia = :idTipoAudiencia")
    , @NamedQuery(name = "TipoAudiencia.findByTipoAudiencia", query = "SELECT t FROM TipoAudiencia t WHERE t.tipoAudiencia = :tipoAudiencia")})
public class TipoAudiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_audiencia")
    private Integer idTipoAudiencia;
    @Size(max = 45)
    @Column(name = "tipo_audiencia")
    private String tipoAudiencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAudiencia")
    private Collection<Audiencia> audienciaCollection;

    public TipoAudiencia() {
    }

    public TipoAudiencia(Integer idTipoAudiencia) {
        this.idTipoAudiencia = idTipoAudiencia;
    }

    public Integer getIdTipoAudiencia() {
        return idTipoAudiencia;
    }

    public void setIdTipoAudiencia(Integer idTipoAudiencia) {
        this.idTipoAudiencia = idTipoAudiencia;
    }

    public String getTipoAudiencia() {
        return tipoAudiencia;
    }

    public void setTipoAudiencia(String tipoAudiencia) {
        this.tipoAudiencia = tipoAudiencia;
    }

    @XmlTransient
    public Collection<Audiencia> getAudienciaCollection() {
        return audienciaCollection;
    }

    public void setAudienciaCollection(Collection<Audiencia> audienciaCollection) {
        this.audienciaCollection = audienciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAudiencia != null ? idTipoAudiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAudiencia)) {
            return false;
        }
        TipoAudiencia other = (TipoAudiencia) object;
        if ((this.idTipoAudiencia == null && other.idTipoAudiencia != null) || (this.idTipoAudiencia != null && !this.idTipoAudiencia.equals(other.idTipoAudiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.TipoAudiencia[ idTipoAudiencia=" + idTipoAudiencia + " ]";
    }
    
}
