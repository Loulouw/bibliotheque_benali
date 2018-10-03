package fr.ul.miage.bibliotheque.dao;
// Generated 3 oct. 2018 12:26:21 by Hibernate Tools 5.0.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.ul.miage.bibliotheque.entite.Reservation;

/**
 * Home object for domain model class Reservation.
 * @see fr.ul.miage.bibliotheque.entite.Reservation
 * @author Hibernate Tools
 */
@Stateless
public class ReservationDao {

	private static final Log log = LogFactory.getLog(ReservationDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Reservation transientInstance) {
		log.debug("persisting Reservation instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Reservation persistentInstance) {
		log.debug("removing Reservation instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Reservation merge(Reservation detachedInstance) {
		log.debug("merging Reservation instance");
		try {
			Reservation result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Reservation findById(Integer id) {
		log.debug("getting Reservation instance with id: " + id);
		try {
			Reservation instance = entityManager.find(Reservation.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
