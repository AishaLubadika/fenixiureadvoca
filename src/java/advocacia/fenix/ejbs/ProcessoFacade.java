/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.ejbs;

import advocacia.fenix.entities.Processo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LUBADIKA
 */
@Stateless
public class ProcessoFacade extends AbstractFacade<Processo> {

    @PersistenceContext(unitName = "advocaciafenixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcessoFacade() {
        super(Processo.class);
    }

    //Consulta feita para pesquisa de numero de processos, ter em conta a diefrença entre JPQL e sql
    public List<Processo> findbynumero(String numeroProcesso) {
        Query query = em.createQuery("SELECT p FROM processo p  WHERE p.numero_processo=:numero_processo", Processo.class);
        query.setParameter("numero_processo", numeroProcesso);
        return query.getResultList();

    }
}
