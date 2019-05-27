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
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")
    , @NamedQuery(name = "Consulta.findByIdConsulta", query = "SELECT c FROM Consulta c WHERE c.idConsulta = :idConsulta")
    , @NamedQuery(name = "Consulta.findByResumoConsulta", query = "SELECT c FROM Consulta c WHERE c.resumoConsulta = :resumoConsulta")
    , @NamedQuery(name = "Consulta.findByValorPagar", query = "SELECT c FROM Consulta c WHERE c.valorPagar = :valorPagar")})
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consulta")
    private Integer idConsulta;
    @Size(max = 255)
    @Column(name = "resumo_consulta")
    private String resumoConsulta;
    @Column(name = "valor_pagar")
    private Long valorPagar;
    @JoinColumn(name = "advogado", referencedColumnName = "id_advogado")
    @ManyToOne(optional = false)
    private Advogado advogado;
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Consulta() {
    }

    public Consulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getResumoConsulta() {
        return resumoConsulta;
    }

    public void setResumoConsulta(String resumoConsulta) {
        this.resumoConsulta = resumoConsulta;
    }

    public Long getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Long valorPagar) {
        this.valorPagar = valorPagar;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advocacia.fenix.entities.Consulta[ idConsulta=" + idConsulta + " ]";
    }
    
}
