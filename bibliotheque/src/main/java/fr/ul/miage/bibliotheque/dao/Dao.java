package fr.ul.miage.bibliotheque.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.ul.miage.bibliotheque.util.HibernateUtil;

public class Dao<T> {

	private Class<T> classT;

	public Dao(Class<T> classT) {
		this.classT = classT;
	}

	public void create(T t) {
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();

			session.persist(t);

			tx.commit();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
	}

	@SuppressWarnings("unchecked")
	public T find(int id) {
		T res = null;
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			res = (T) session.get(classT, id);
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> res = new ArrayList<>();
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			res.addAll(session.createCriteria(classT).list());
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return res;
	}

	public void update(T t) {
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			session.update(t);

			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
	}

	@SuppressWarnings("unchecked")
	public void delete(int id) {
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			T tempT = (T) session.get(classT, id);
			session.delete(tempT);

			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
	}

	@SuppressWarnings("unchecked")
	public void delete(T t) {
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();
			session.delete(t);

			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
	}
}
