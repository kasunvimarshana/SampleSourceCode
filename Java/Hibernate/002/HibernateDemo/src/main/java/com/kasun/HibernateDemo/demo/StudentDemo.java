package com.kasun.HibernateDemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kasun.HibernateDemo.student.Laptop;
import com.kasun.HibernateDemo.student.Student;

public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Laptop l = new Laptop();
		l.setlId(1);
		l.setlName("test");
		
		Student s = new Student();
		s.setsId(1);
		s.setsName("test");
		s.setMarks(1);
		s.getLaptops().add(l);
		
		Configuration configure = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configure.getProperties()).buildServiceRegistry();
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
    	SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(l);
    	session.save(s);
    	tx.commit();
	}

}
