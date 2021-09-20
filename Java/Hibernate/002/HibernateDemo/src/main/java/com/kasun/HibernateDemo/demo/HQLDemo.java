package com.kasun.HibernateDemo.demo;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kasun.HibernateDemo.alien.Alien;
import com.kasun.HibernateDemo.student.Laptop;
import com.kasun.HibernateDemo.student.Student;

public class HQLDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configure = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configure.getProperties()).buildServiceRegistry();
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
    	SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
    	
    	/*
		// Demo 1
    	session.beginTransaction();
		
    	Random r = new Random();
    	for (int i = 1; i <= 50; i++) {
    		Student s = new Student();
    		s.setsId(i);
    		s.setsName("Name " + i);
    		s.setMarks(r.nextInt(100));
    		
    		session.save(s);
    	}
    	
		session.getTransaction().commit();
		*/
    	
    	/*
		// Demo 2
    	session.beginTransaction();
    	
    	Query q = session.createQuery("from Student");
    	List<Student> students = q.list();
    	
    	for(Student s : students){
    		System.out.println( s );
    	}
    	
    	session.getTransaction().commit();
    	*/
    	
    	/*
    	// Demo 3
    	session.beginTransaction();
    	
    	Query q = session.createQuery("from Student where marks > 30");
    	List<Student> students = q.list();
    	
    	for(Student s : students){
    		System.out.println( s );
    	}
    	
    	session.getTransaction().commit();
    	*/
    	
    	/*
    	// Demo 4
    	session.beginTransaction();
    	
    	Query q = session.createQuery("from Student where sId = 2");
    	Student student = (Student) q.uniqueResult();
    	System.out.println( student );
    	
    	session.getTransaction().commit();
    	*/
    	
    	/*
    	// Demo 5
    	session.beginTransaction();
    	
    	Query q = session.createQuery("select sId, sName, marks from Student where sId = 2");
    	Object[] student = (Object[]) q.uniqueResult();
    	
    	for( Object o : student ) {
    		System.out.println( o );
    	}
    	
    	session.getTransaction().commit();
    	*/
    	
    	/*
    	// Demo 6
    	session.beginTransaction();
    	
    	Query q = session.createQuery("select sId, sName, marks from Student");
    	List<Object[]> students = (List<Object[]>) q.list();
    	
    	for( Object[] o : students ) {
    		System.out.println( o[0] + " : " + o[1] + " : " + o[2] );
    	}
    	
    	session.getTransaction().commit();
    	*/
    	
    	/*
    	// Demo 7
    	session.beginTransaction();
    	
    	Query q = session.createQuery("from Student where sId = :id");
    	q.setParameter("id", 3);
    	Student student = (Student) q.uniqueResult();
    	System.out.println( student );
    	
    	session.getTransaction().commit();
    	*/
    	
    	/*
    	// Demo 7
    	session.beginTransaction();
    	
    	SQLQuery q = session.createSQLQuery("select * from student where marks > 60");
    	q.addEntity(Student.class);
    	List<Student> students = q.list();
    	
    	for(Student s : students) {
    		System.out.println( s );
    	}
    	
    	session.getTransaction().commit();
    	*/
    	
    	// Demo 8
    	session.beginTransaction();
    	
    	SQLQuery q = session.createSQLQuery("select sname, marks from student where marks > 60");
    	q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	List students = q.list();
    	
    	for(Object s : students) {
    		Map m = (Map) s;
    		System.out.println( m.get("sname") + " : " + m.get("marks") );
    	}
    	
    	session.getTransaction().commit();
	}

}
