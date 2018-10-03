package fr.ul.miage.bibliotheque.dao;
// Generated 3 oct. 2018 12:26:21 by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.ul.miage.bibliotheque.entite.Usager;

/**
 * Home object for domain model class Usager.
 * @see fr.ul.miage.bibliotheque.entite.Usager
 * @author Hibernate Tools
 */
@Stateless
public class UsagerDao {

	private static final Log log = LogFactory.getLog(UsagerDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Usager transientInstance) {
		log.debug("persisting Usager instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Usager persistentInstance) {
		log.debug("removing Usager instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Usager merge(Usager detachedInstance) {
		log.debug("merging Usager instance");
		try {
			Usager result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usager findById(Integer id) {
		log.debug("getting Usager instance with id: " + id);
		try {
			Usager instance = entityManager.find(Usager.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
