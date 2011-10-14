package test;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.entity.VersionTest;

@Stateless
public class TestEJB2 {

	@PersistenceContext
	private EntityManager em;
	
	public void check1(VersionTest v) {
		VersionTest v1 = em.find(VersionTest.class, 93l);
	}
}
