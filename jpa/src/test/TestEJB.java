package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.EJB;
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
		v.setVal("moj zajebisty rekord, nie tykac");
		em.persist(v);
		System.out.println(v.getId() + ", "+ v.getVer());
	}
	
	
	@Resource(mappedName="java:jboss/datasource/postgres")
	private javax.sql.DataSource postgres;
	
	public void check2() throws SQLException {
		VersionTest v = em.find(VersionTest.class, 93l);
		System.out.println("ok");
		v.setVal(v.getVal()+"d");
		
		Connection conn = postgres.getConnection(); 
		ResultSet rs = conn.createStatement().executeQuery("select val from version_test where id = 93");
		rs.next();
		System.out.println(rs.getString(1));
		conn.close();
	}
	
	public void check3() {
		VersionTest v = em.find(VersionTest.class, 93l);
		System.out.println(v.getVal());
	}
	
	@EJB
	private TestEJB2 ejb2;

	public void check4() {
		VersionTest v = em.find(VersionTest.class, 93l);
		ejb2.check1(v);
	}
}
