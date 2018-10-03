package fr.ul.miage.bibliotheque.dao;
// Generated 3 oct. 2018 12:26:21 by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.ul.miage.bibliotheque.entite.Auteur;

/**
 * Home object for domain model class Auteur.
 * @see fr.ul.miage.bibliotheque.entite.Auteur
 * @author Hibernate Tools
 */
@Stateless
public class AuteurDao {

	private static final Log log = LogFactory.getLog(AuteurDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Auteur transientInstance) {
		log.debug("persisting Auteur instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Auteur persistentInstance) {
		log.debug("removing Auteur instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Auteur merge(Auteur detachedInstance) {
		log.debug("merging Auteur instance");
		try {
			Auteur result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Auteur findById(Integer id) {
		log.debug("getting Auteur instance with id: " + id);
		try {
			Auteur instance = entityManager.find(Auteur.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
