package manytomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany.dto.Langauge;
import manytomany.dto.Person;

public class LangaugeDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rushi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveLangauge(Langauge langauge) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(langauge);
		entityTransaction.commit();
	}

	public void fetchLangauge(int id) {
		EntityManager entityManager = getEntityManager();
		Langauge langauge = entityManager.find(Langauge.class, id);
		if (langauge != null) {
			System.out.println(langauge);
		} else {
			System.out.println("langauge is not present with this Id S" + id);
		}

	}

	public void fetchAllLangauge() {
		System.out.println(getEntityManager().createQuery("SELECT l FROM Langauge l").getResultList());

	}

	public void UpdateLangauge(int id, Langauge langauge1) {
		EntityManager entityManager = getEntityManager();
		Langauge langauge = entityManager.find(Langauge.class, id);
		if (langauge != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(langauge1);
			entityTransaction.commit();
		} else {
			System.out.println("langauge is not present with this Id S" + id);
		}

	}

	public void deleteLangauge(int id) {

		EntityManager entityManager = getEntityManager();
		Langauge langauge = entityManager.find(Langauge.class, id);
		if (langauge != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<Person> list = entityManager.createQuery("SELECT p FROM Person p").getResultList();
			for (Person person : list) {
				List<Langauge> list1 = person.getList();
				list1.remove(langauge);
				
			}

			entityManager.remove(langauge);
			
			entityTransaction.commit();
		} else {
			System.out.println("langauge is not present with this Id " + id);
		}

	}
}
