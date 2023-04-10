package com.jspiders.hibernate_annotations.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.jspiders.hibernate_annotations.dto.TrainerDTO;

public class TrainerDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("annotations");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		
	}
	private static void closeConnection() {
		if (factory !=null) {
			factory.close();
		}
		if (manager !=null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			
			openConnection();
			
			transaction.begin();
			
			TrainerDTO trainer=new TrainerDTO();
			trainer.setName("Dhananjay");
			trainer.setSubject("J2EE");
			manager.persist(trainer);
			transaction.commit();
			
		} finally {
			closeConnection();
		}
	}
}
