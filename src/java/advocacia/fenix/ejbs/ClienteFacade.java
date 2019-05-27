/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advocacia.fenix.ejbs;

import advocacia.fenix.entities.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "advocaciafenixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public List<Cliente> findByNome(String nome) {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.nome_cliente=:nome_cliente", Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    public List<Cliente> findBySobrenome(String sobrenome) {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.apelido_cliente =:apelido_cliente", Cliente.class);
        query.setParameter("sobrenome", "%" + sobrenome + "%");
        return query.getResultList();
    }

    public List<Cliente> findByNomeSobrenome(String nome, String sobrenome) {
        Query query = em.createQuery("SELECT c FROM Cliente f WHERE c.nome_cliente= :nome_cliente AND c.apelido_cliente = :apelido_cliente ORDER BY ASC");
        query.setParameter("nome", "%" + nome + "%");
        query.setParameter("sobrenome", "%" + sobrenome + "%");
       
        return query.getResultList();
    }

}
