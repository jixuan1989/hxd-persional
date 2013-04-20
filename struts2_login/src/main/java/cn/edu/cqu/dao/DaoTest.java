package cn.edu.cqu.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.edu.cqu.domains.User;
import cn.edu.cqu.domains.UserType;

public class DaoTest {
	


	public static void main(String[] strs) {
		EntityManagerFactory fac = null;
		EntityManager em = null;
		fac = Persistence.createEntityManagerFactory("tlxweb",System.getProperties());
		em = fac.createEntityManager();
		em.getTransaction().begin();
		User user=new User();
		user.setLoginName("黄向东");
		user.setPwd("cba");
		user.setType(UserType.ADMIN);
		em.persist(user);
		em.getTransaction().commit();
		User user2=em.find(User.class, 3L);
		System.err.println(user2.getLoginName());
		em.close();
		;
	}
}
