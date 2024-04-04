package manytomany.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany.dto.Langauge;
import manytomany.dto.Person;

public class PersonDao {
	public  EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushi");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		List<Langauge> list=person.getList();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		for (Langauge langauge : list) {
			Langauge langauge2=entityManager.find(Langauge.class, langauge.getId());
			
				entityManager.merge(langauge);
			
		}
		entityManager.persist(person);
		entityTransaction.commit();
		
	}
	public void addLangaugePerson(int pid,List list) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, pid);
		if(person!=null) {
			Person person1=new Person();
			person1.setId(person.getId());
			person1.setName(person.getName());
			person1.setPhone(person.getPhone());
			person1.setAddress(person.getAddress());
			List list1=person.getList();
			Iterator<Integer> iterator=list.iterator();
			while(iterator.hasNext()) {
				int id=iterator.next();
				Langauge langauge=entityManager.find(Langauge.class, id);
				if(!list1.contains(langauge))
				list1.add(langauge);
			}
			person1.setList(list1);
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(person1);
			entityTransaction.commit();
		}
		else {
			System.out.println("Person is not present");
		}
	}
	public void updatePerson(int pid,Person person1) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, pid);
		if(person!=null) {
			person1.setList(person.getList());
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(person1);
			entityTransaction.commit();
			
		}else {
			System.out.println("Person is not present");
		}
		
	}
	public void deletePerson(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);
		if(person!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person is not present");
		}
		
	}
	public void getPersonById(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);
		if(person!=null) {
			System.out.println(person);
		}else {
			System.out.println("Person is not present");
		}
		
	}
	public void fetchAllPerson() {
		System.out.println(getEntityManager().createQuery("SELECT p FROM Person p").getResultList());
		
	}
}
