/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.ejbs;

import advocacia.fenix.entities.Advogado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LUBADIKA
 */
@Stateless
public class AdvogadoFacade extends AbstractFacade<Advogado> {

    @PersistenceContext(unitName = "advocaciafenixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdvogadoFacade() {
        super(Advogado.class);
    }
    
    //Query bynumerobi= em.createQuery("select a from Advogado a where a.numeroBiAdvogado=:numeroBiAdvogado");
    //Advogado advo= (Advogado)bynumerobi.g
}
