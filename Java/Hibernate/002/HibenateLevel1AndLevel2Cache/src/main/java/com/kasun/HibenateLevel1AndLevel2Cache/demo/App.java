package com.kasun.HibenateLevel1AndLevel2Cache.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kasun.HibenateLevel1AndLevel2Cache.alien.Alien;
import com.kasun.HibenateLevel1AndLevel2Cache.alien.AlienName;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	Alien a = null;
    	
    	Configuration configure = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
    	//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configure.getProperties()).buildServiceRegistry();
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
    	SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);
    	
    	Session session1 = sessionFactory.openSession();
    	session1.getTransaction().begin();
    	a = (Alien) session1.get(Alien.class, 1);
    	session1.getTransaction().commit();
    	session1.close();
    	
    	System.out.println( a );
    	
    	Session session2 = sessionFactory.openSession();
    	session2.getTransaction().begin();
    	a = (Alien) session2.get(Alien.class, 1);
    	session2.getTransaction().commit();
    	session2.close();
    	
    	System.out.println( a );
    }
}
