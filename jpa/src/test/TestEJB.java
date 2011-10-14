package test;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.entity.VersionTest;


@Stateless
public class TestEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void check1() {
		VersionTest v = new VersionTest();
		v.setVal("abc");
		em.persist(v);
		System.out.println(v.getId() + ", "+ v.getVer());
	}
	
	public void check2() {
		VersionTest v = em.find(VersionTest.class, 61l);
		System.out.println("ok");
		v.setVal(v.getVal()+"d");
	}
	
	public void check3() {
		VersionTest v = em.find(VersionTest.class, 61l);
		System.out.println(v.getVal());
	}
}
