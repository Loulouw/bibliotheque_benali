package fr.ul.miage.bibliotheque.dao;
// Generated 3 oct. 2018 12:26:21 by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.ul.miage.bibliotheque.entite.Etat;

/**
 * Home object for domain model class Etat.
 * @see fr.ul.miage.bibliotheque.entite.Etat
 * @author Hibernate Tools
 */
@Stateless
public class EtatDao {

	private static final Log log = LogFactory.getLog(EtatDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Etat transientInstance) {
		log.debug("persisting Etat instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Etat persistentInstance) {
		log.debug("removing Etat instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Etat merge(Etat detachedInstance) {
		log.debug("merging Etat instance");
		try {
			Etat result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Etat findById(Integer id) {
		log.debug("getting Etat instance with id: " + id);
		try {
			Etat instance = entityManager.find(Etat.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
