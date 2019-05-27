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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUBADIKA
 */
@Entity
@Table(name = "honorario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Honorario.findAll", query = "SELECT h FROM Honorario h")
    , @NamedQuery(name = "Honorario.findByIdHonorario", query = "SELECT h FROM Honorario h WHERE h.idHonorario = :idHonorario")
    , @NamedQuery(name = "Honorario.findByDataVencimento", query = "SELECT h FROM Honorario h WHERE h.dataVencimento = :dataVencimento")
    , @NamedQuery(name = "Honorario.findByDataLancamento", query = "SELECT h FROM Honorario h WHERE h.dataLancamento = :dataLancamento")
    , @NamedQuery(name = "Honorario.findByValorLancamento", query = "SELECT h FROM Honorario h WHERE h.valorLancamento = :valorLancamento")
    , @NamedQuery(name = "Honorario.findByValorPagamento", query = "SELECT h FROM Honorario h WHERE h.valorPagamento = :valorPagamento")})
public class Honorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_honorario")
    private Integer idHonorario;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "data_lancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "valor_lancamento")
    private Long valorLancamento;
    @Column(name = "valor_pagamento")
    private Long valorPagamento;
    @JoinColumn(name = "processo", referencedColumnName = "id_processo")
    @ManyToOne(optional = false)
    private Processo processo;

    public Honorario() {
    }

    public Honorario(Integer idHonorario) {
        this.idHonorario = idHonorario;
    }

    public Integer getIdHonorario() {
        return idHonorario;
    }

    public void setIdHonorario(Integer idHonorario) {
        this.idHonorario = idHonorario;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Long getValorLancamento() {
        return valorLancamento;
    }

    public void setValorLancamento(Long valorLancamento) {
        this.valorLancamento = valorLancamento;
    }

    public Long getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Long valorPagamento) {
        this.valorPagamento = valorPagamento;
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
        hash += (idHonorario != null ? idHonorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Honorario)) {
            return false;
        }
        Honorario other = (Honorario) object;
        if ((this.idHonorario == null && other.idHonorario != null) || (this.idHonorario != null && !this.idHonorario.equals(other.idHonorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.Honorario[ idHonorario=" + idHonorario + " ]";
    }
    
}
