package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "AK", "ak@email.com");
		Pessoa p2 = new Pessoa(null, "Asuka Langley", "asuka@email.com");
		Pessoa p3 = new Pessoa(null, "Rei Ayanami", "ayanami@email.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit();
		
		
		Pessoa p = em.find(Pessoa.class, 1);
		System.out.println(p);
		
		em.close();
		emf.close();
		
		System.out.println("Fim!");
		
	}
}
