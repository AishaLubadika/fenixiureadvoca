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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUBADIKA
 */
@Entity
@Table(name = "processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processo.findAll", query = "SELECT p FROM Processo p")
    , @NamedQuery(name = "Processo.findByIdProcesso", query = "SELECT p FROM Processo p WHERE p.idProcesso = :idProcesso")
    , @NamedQuery(name = "Processo.findByNumeroProcesso", query = "SELECT p FROM Processo p WHERE p.numeroProcesso = :numeroProcesso")
    , @NamedQuery(name = "Processo.findByDataEntrada", query = "SELECT p FROM Processo p WHERE p.dataEntrada = :dataEntrada")
    , @NamedQuery(name = "Processo.findByObsevacoes", query = "SELECT p FROM Processo p WHERE p.obsevacoes = :obsevacoes")
    , @NamedQuery(name = "Processo.findByDataConclusao", query = "SELECT p FROM Processo p WHERE p.dataConclusao = :dataConclusao")
    , @NamedQuery(name = "Processo.findByAdvogadoContrario", query = "SELECT p FROM Processo p WHERE p.advogadoContrario = :advogadoContrario")})
public class Processo implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processo")
    private Collection<DespesaProcesso> despesaProcessoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processo")
    private Collection<Audiencia> audienciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processo")
    private Collection<Honorario> honorarioCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Size(max = 45)
    @Column(name = "numero_processo")
    private String numeroProcesso;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Size(max = 255)
    @Column(name = "obsevacoes")
    private String obsevacoes;
    @Column(name = "data_conclusao")
    @Temporal(TemporalType.DATE)
    private Date dataConclusao;
    @Size(max = 45)
    @Column(name = "advogado_contrario")
    private String advogadoContrario;
    @JoinColumn(name = "advogado", referencedColumnName = "id_advogado")
    @ManyToOne(optional = false)
    private Advogado advogado;
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "estado_processo", referencedColumnName = "id_estado_processo")
    @ManyToOne(optional = false)
    private EstadoProcesso estadoProcesso;
    @JoinColumn(name = "requerido", referencedColumnName = "id_requerido")
    @ManyToOne(optional = false)
    private Requerido requerido;
    @JoinColumn(name = "tipo_decisao", referencedColumnName = "id_tipo_decisao")
    @ManyToOne(optional = false)
    private TipoDecisao tipoDecisao;
    @JoinColumn(name = "tipo_processo", referencedColumnName = "id_tipo_processo")
    @ManyToOne(optional = false)
    private TipoProcesso tipoProcesso;

    public Processo() {
    }

    public Processo(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getObsevacoes() {
        return obsevacoes;
    }

    public void setObsevacoes(String obsevacoes) {
        this.obsevacoes = obsevacoes;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getAdvogadoContrario() {
        return advogadoContrario;
    }

    public void setAdvogadoContrario(String advogadoContrario) {
        this.advogadoContrario = advogadoContrario;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoProcesso getEstadoProcesso() {
        return estadoProcesso;
    }

    public void setEstadoProcesso(EstadoProcesso estadoProcesso) {
        this.estadoProcesso = estadoProcesso;
    }

    public Requerido getRequerido() {
        return requerido;
    }

    public void setRequerido(Requerido requerido) {
        this.requerido = requerido;
    }

    public TipoDecisao getTipoDecisao() {
        return tipoDecisao;
    }

    public void setTipoDecisao(TipoDecisao tipoDecisao) {
        this.tipoDecisao = tipoDecisao;
    }

    public TipoProcesso getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(TipoProcesso tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesso != null ? idProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processo)) {
            return false;
        }
        Processo other = (Processo) object;
        if ((this.idProcesso == null && other.idProcesso != null) || (this.idProcesso != null && !this.idProcesso.equals(other.idProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.Processo[ idProcesso=" + idProcesso + " ]";
    }

    @XmlTransient
    public Collection<DespesaProcesso> getDespesaProcessoCollection() {
        return despesaProcessoCollection;
    }

    public void setDespesaProcessoCollection(Collection<DespesaProcesso> despesaProcessoCollection) {
        this.despesaProcessoCollection = despesaProcessoCollection;
    }

    @XmlTransient
    public Collection<Audiencia> getAudienciaCollection() {
        return audienciaCollection;
    }

    public void setAudienciaCollection(Collection<Audiencia> audienciaCollection) {
        this.audienciaCollection = audienciaCollection;
    }

    @XmlTransient
    public Collection<Honorario> getHonorarioCollection() {
        return honorarioCollection;
    }

    public void setHonorarioCollection(Collection<Honorario> honorarioCollection) {
        this.honorarioCollection = honorarioCollection;
    }
    
}
