package com.kasun.HibenateLevel1AndLevel2Cache.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kasun.HibenateLevel1AndLevel2Cache.alien.Alien;

public class QueryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alien a = null;
		
		Configuration configure = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configure.getProperties()).buildServiceRegistry();
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
    	SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);
    	
    	Session session1 = sessionFactory.openSession();
    	session1.beginTransaction();
    	Query q1 = session1.createQuery("from Alien where aid = 1");
    	q1.setCacheable(true);
    	a = (Alien) q1.uniqueResult();
    	session1.getTransaction().commit();
    	session1.close();
    	
    	System.out.println( a );
    	
    	Session session2 = sessionFactory.openSession();
    	session2.beginTransaction();
    	Query q2 = session2.createQuery("from Alien where aid = 1");
    	q1.setCacheable(true);
    	a = (Alien) q2.uniqueResult();
    	session2.getTransaction().commit();
    	session2.close();
    	
    	System.out.println( a );

	}

}
