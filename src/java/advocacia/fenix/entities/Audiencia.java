/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUBADIKA
 */
@Entity
@Table(name = "audiencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audiencia.findAll", query = "SELECT a FROM Audiencia a")
    , @NamedQuery(name = "Audiencia.findByIdAudiencia", query = "SELECT a FROM Audiencia a WHERE a.idAudiencia = :idAudiencia")
    , @NamedQuery(name = "Audiencia.findByDataAudiencia", query = "SELECT a FROM Audiencia a WHERE a.dataAudiencia = :dataAudiencia")
    , @NamedQuery(name = "Audiencia.findByHoraAudiencia", query = "SELECT a FROM Audiencia a WHERE a.horaAudiencia = :horaAudiencia")})
public class Audiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_audiencia")
    private Integer idAudiencia;
    @Column(name = "data_audiencia")
    @Temporal(TemporalType.DATE)
    private Date dataAudiencia;
    @Size(max = 20)
    @Column(name = "hora_audiencia")
    private String horaAudiencia;
    @JoinColumn(name = "tipo_audiencia_", referencedColumnName = "id_tipo_audiencia")
    @ManyToOne(optional = false)
    private TipoAudiencia tipoAudiencia;
    @JoinColumn(name = "processo", referencedColumnName = "id_processo")
    @ManyToOne(optional = false)
    private Processo processo;

    public Audiencia() {
    }

    public Audiencia(Integer idAudiencia) {
        this.idAudiencia = idAudiencia;
    }

    public Integer getIdAudiencia() {
        return idAudiencia;
    }

    public void setIdAudiencia(Integer idAudiencia) {
        this.idAudiencia = idAudiencia;
    }

    public Date getDataAudiencia() {
        return dataAudiencia;
    }

    public void setDataAudiencia(Date dataAudiencia) {
        this.dataAudiencia = dataAudiencia;
    }

    public String getHoraAudiencia() {
        return horaAudiencia;
    }

    public void setHoraAudiencia(String horaAudiencia) {
        this.horaAudiencia = horaAudiencia;
    }

    public TipoAudiencia getTipoAudiencia() {
        return tipoAudiencia;
    }

    public void setTipoAudiencia(TipoAudiencia tipoAudiencia) {
        this.tipoAudiencia = tipoAudiencia;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAudiencia != null ? idAudiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Audiencia)) {
            return false;
        }
        Audiencia other = (Audiencia) object;
        if ((this.idAudiencia == null && other.idAudiencia != null) || (this.idAudiencia != null && !this.idAudiencia.equals(other.idAudiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.Audiencia[ idAudiencia=" + idAudiencia + " ]";
    }
    
}
