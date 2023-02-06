
package reto.principal.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import reto.principal.logica.Naves;
import reto.principal.persistencia.exceptions.NonexistentEntityException;


public class NavesJpaController implements Serializable {

    public NavesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
    public NavesJpaController( ) {
        emf = Persistence.createEntityManagerFactory("NavesPU");
    }
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Naves naves) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(naves);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Naves naves) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            naves = em.merge(naves);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = naves.getNumNave();
                if (findNaves(id) == null) {
                    throw new NonexistentEntityException("The naves with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Naves naves;
            try {
                naves = em.getReference(Naves.class, id);
                naves.getNumNave();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The naves with id " + id + " no longer exists.", enfe);
            }
            em.remove(naves);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Naves> findNavesEntities() {
        return findNavesEntities(true, -1, -1);
    }

    public List<Naves> findNavesEntities(int maxResults, int firstResult) {
        return findNavesEntities(false, maxResults, firstResult);
    }

    private List<Naves> findNavesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Naves.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Naves findNaves(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Naves.class, id);
        } finally {
            em.close();
        }
    }

    public int getNavesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Naves> rt = cq.from(Naves.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    void create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
