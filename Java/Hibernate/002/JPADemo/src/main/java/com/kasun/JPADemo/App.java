package com.kasun.JPADemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	Alien a = entityManager.find(Alien.class, 1);
    	System.out.println( a );
    }
}
