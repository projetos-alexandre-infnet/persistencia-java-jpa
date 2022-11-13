package br.edu.infnet.apppagamento.model.persistence;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class JpaDAO<T> implements IDAO<T> {

	protected EntityManager em;

	private Class<T> entityClass;

	public JpaDAO() {
		ParameterizedType generic = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) generic.getActualTypeArguments()[0];
		em = JpaUtil.createEntityManager();
	}

	@Override
	public void save(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void update(T t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public T getById(Integer id) {
		return em.find(entityClass, id);
	}

	@Override
	public List<T> listAll() {
		return em.createQuery("from " + entityClass.getName()).getResultList();
	}
}