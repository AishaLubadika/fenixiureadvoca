/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.ejbs;

import advocacia.fenix.entities.TipoAudiencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LUBADIKA
 */
@Stateless
public class TipoAudienciaFacade extends AbstractFacade<TipoAudiencia> {

    @PersistenceContext(unitName = "advocaciafenixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAudienciaFacade() {
        super(TipoAudiencia.class);
    }
    
}
