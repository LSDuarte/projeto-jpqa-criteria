package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriaTabelas {

	public static void main(String[] args) {
		//criando fabrica entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager createEntityManager =  emf.createEntityManager();
		emf.close();
	}

}