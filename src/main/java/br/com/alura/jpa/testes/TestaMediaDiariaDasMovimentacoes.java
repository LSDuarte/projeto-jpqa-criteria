package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		// + de 2 colunas
		String jpql = "select day(m.data), month(m.data), avg(m.valor) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

		// array de object para representar
		Query query = em.createQuery(jpql);
		List<Object[]> mediaValores = query.getResultList();

		for (Object[] resultado : mediaValores) {
			System.out.println("Média dos valores do dia " + resultado[1] + "/" + resultado[2] + " é: " + resultado[0]);
		}

	}

}