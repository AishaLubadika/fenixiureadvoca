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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUBADIKA
 */
@Entity
@Table(name = "despesa_processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DespesaProcesso.findAll", query = "SELECT d FROM DespesaProcesso d")
    , @NamedQuery(name = "DespesaProcesso.findByIdDespesaProcesso", query = "SELECT d FROM DespesaProcesso d WHERE d.idDespesaProcesso = :idDespesaProcesso")
    , @NamedQuery(name = "DespesaProcesso.findByDescicao", query = "SELECT d FROM DespesaProcesso d WHERE d.descicao = :descicao")
    , @NamedQuery(name = "DespesaProcesso.findByValorDespesa", query = "SELECT d FROM DespesaProcesso d WHERE d.valorDespesa = :valorDespesa")})
public class DespesaProcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_despesa_processo")
    private Integer idDespesaProcesso;
    @Size(max = 45)
    @Column(name = "descicao")
    private String descicao;
    @Column(name = "valor_despesa")
    private Long valorDespesa;
    @JoinColumn(name = "processo", referencedColumnName = "id_processo")
    @ManyToOne(optional = false)
    private Processo processo;

    public DespesaProcesso() {
    }

    public DespesaProcesso(Integer idDespesaProcesso) {
        this.idDespesaProcesso = idDespesaProcesso;
    }

    public Integer getIdDespesaProcesso() {
        return idDespesaProcesso;
    }

    public void setIdDespesaProcesso(Integer idDespesaProcesso) {
        this.idDespesaProcesso = idDespesaProcesso;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public Long getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(Long valorDespesa) {
        this.valorDespesa = valorDespesa;
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
        hash += (idDespesaProcesso != null ? idDespesaProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DespesaProcesso)) {
            return false;
        }
        DespesaProcesso other = (DespesaProcesso) object;
        if ((this.idDespesaProcesso == null && other.idDespesaProcesso != null) || (this.idDespesaProcesso != null && !this.idDespesaProcesso.equals(other.idDespesaProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.DespesaProcesso[ idDespesaProcesso=" + idDespesaProcesso + " ]";
    }
    
}
