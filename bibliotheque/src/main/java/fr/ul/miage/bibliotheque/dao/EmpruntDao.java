package fr.ul.miage.bibliotheque.dao;
// Generated 3 oct. 2018 12:26:21 by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.ul.miage.bibliotheque.entite.Emprunt;

/**
 * Home object for domain model class Emprunt.
 * @see fr.ul.miage.bibliotheque.entite.Emprunt
 * @author Hibernate Tools
 */
@Stateless
public class EmpruntDao {

	private static final Log log = LogFactory.getLog(EmpruntDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Emprunt transientInstance) {
		log.debug("persisting Emprunt instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Emprunt persistentInstance) {
		log.debug("removing Emprunt instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Emprunt merge(Emprunt detachedInstance) {
		log.debug("merging Emprunt instance");
		try {
			Emprunt result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Emprunt findById(Integer id) {
		log.debug("getting Emprunt instance with id: " + id);
		try {
			Emprunt instance = entityManager.find(Emprunt.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
