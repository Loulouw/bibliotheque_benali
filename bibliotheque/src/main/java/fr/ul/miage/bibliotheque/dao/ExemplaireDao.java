package fr.ul.miage.bibliotheque.dao;
// Generated 3 oct. 2018 12:26:21 by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.ul.miage.bibliotheque.entite.Exemplaire;

/**
 * Home object for domain model class Exemplaire.
 * @see fr.ul.miage.bibliotheque.entite.Exemplaire
 * @author Hibernate Tools
 */
@Stateless
public class ExemplaireDao {

	private static final Log log = LogFactory.getLog(ExemplaireDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Exemplaire transientInstance) {
		log.debug("persisting Exemplaire instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Exemplaire persistentInstance) {
		log.debug("removing Exemplaire instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Exemplaire merge(Exemplaire detachedInstance) {
		log.debug("merging Exemplaire instance");
		try {
			Exemplaire result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Exemplaire findById(Integer id) {
		log.debug("getting Exemplaire instance with id: " + id);
		try {
			Exemplaire instance = entityManager.find(Exemplaire.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
