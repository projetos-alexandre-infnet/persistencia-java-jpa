package br.edu.infnet.apppagamento.model.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("pu");
	}
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
}