package fr.ul.miage.bibliotheque.dao;
// Generated 3 oct. 2018 12:26:21 by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.ul.miage.bibliotheque.entite.TypeOeuvre;

/**
 * Home object for domain model class TypeOeuvre.
 * @see fr.ul.miage.bibliotheque.entite.TypeOeuvre
 * @author Hibernate Tools
 */
@Stateless
public class TypeOeuvreDao {

	private static final Log log = LogFactory.getLog(TypeOeuvreDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TypeOeuvre transientInstance) {
		log.debug("persisting TypeOeuvre instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TypeOeuvre persistentInstance) {
		log.debug("removing TypeOeuvre instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TypeOeuvre merge(TypeOeuvre detachedInstance) {
		log.debug("merging TypeOeuvre instance");
		try {
			TypeOeuvre result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TypeOeuvre findById(Integer id) {
		log.debug("getting TypeOeuvre instance with id: " + id);
		try {
			TypeOeuvre instance = entityManager.find(TypeOeuvre.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
