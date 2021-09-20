package com.kasun.HibernateDemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kasun.HibernateDemo.alien.Alien;
import com.kasun.HibernateDemo.alien.AlienName;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	AlienName aN = new AlienName();
    	aN.setfName("f");
    	aN.setmName("m");
    	aN.setlName("l");
    	
    	Alien a = new Alien();
    	a.setAid(1);
    	a.setAname(aN);
    	a.setColor("red");
    	
    	Configuration configure = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
    	//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configure.getProperties()).buildServiceRegistry();
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
    	SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(a);
    	tx.commit();
    }
}
