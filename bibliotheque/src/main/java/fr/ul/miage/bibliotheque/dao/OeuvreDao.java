package fr.ul.miage.bibliotheque.dao;
// Generated 3 oct. 2018 12:26:21 by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.ul.miage.bibliotheque.entite.Oeuvre;

/**
 * Home object for domain model class Oeuvre.
 * @see fr.ul.miage.bibliotheque.entite.Oeuvre
 * @author Hibernate Tools
 */
@Stateless
public class OeuvreDao {

	private static final Log log = LogFactory.getLog(OeuvreDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Oeuvre transientInstance) {
		log.debug("persisting Oeuvre instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Oeuvre persistentInstance) {
		log.debug("removing Oeuvre instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Oeuvre merge(Oeuvre detachedInstance) {
		log.debug("merging Oeuvre instance");
		try {
			Oeuvre result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Oeuvre findById(Integer id) {
		log.debug("getting Oeuvre instance with id: " + id);
		try {
			Oeuvre instance = entityManager.find(Oeuvre.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
