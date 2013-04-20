package cn.edu.cqu.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import cn.edu.cqu.domains.Authority;
import cn.edu.cqu.domains.Department;
import cn.edu.cqu.domains.ScholarshipType;
import cn.edu.cqu.domains.Team;
import cn.edu.cqu.domains.User;

public class DaoUtils {
	static EntityManagerFactory fac = null;
	//EntityManager em = null;
	public static void init(){
		fac = Persistence.createEntityManagerFactory("tlxweb",System.getProperties());
		EntityManager em=getWriteEntityManager();
		//em.find(entityClass, primaryKey)
		TypedQuery<Team> query=em.createQuery("select t from Team t", Team.class);
		//query.setParameter(1, "秘书部");
		List<Team> teams=query.getResultList();
		if(teams.size()==0){
			Team team = new Team();
			team.setName("渝悦团");
			team.setRegion("重庆");
			Department department = new Department();
			department.setName("秘书部");
			department.setTeam(team);
			Authority authority = new Authority();
			authority.setName("管理员");
			department.setAuthority(authority);
			User root=new User();
			root.setLoginName("root");
			root.setPwd("toor");
			root.setDepartment(department);
			root.setBankName("中国银行");
			root.setBankAccount("12345656");
			root.setCquNo("20085502");
			root.setEmail("wangmengtest@cqu.edu.cn");
			root.setCurrentAddress("llalalalal");
			root.setName("大王");
			root.setPosition("root");
			root.setScholarshipTime(new Date());
			root.setScholarshipType(ScholarshipType.TLXJiangXueJin);
			root.setSex("f");
			root.setTel("15123303916");
			em.persist(team);
			em.persist(authority);
			em.persist(department);
			em.persist(root);
		}
		saveAndCloseEntityManger(em);
	}
	public static EntityManager getEntityManager(){
		return fac.createEntityManager();
	}
	public static EntityManager getWriteEntityManager(){
		EntityManager emEntityManager=fac.createEntityManager();
		emEntityManager.getTransaction().begin();
		return emEntityManager;
	}
	public static void closeEntityManager(EntityManager em){
		em.close();
	}
	public static void saveAndCloseEntityManger(EntityManager em){
		if(em.getTransaction().isActive()){
			em.getTransaction().commit();
		}
		em.close();
	}
	@Override
	protected void finalize() throws Throwable {
		if(fac!=null){
			fac.close();
		}
		super.finalize();
	}

}
