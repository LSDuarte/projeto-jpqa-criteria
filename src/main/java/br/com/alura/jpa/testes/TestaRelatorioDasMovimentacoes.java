package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {

	public static void main(String[] args) {

		// crio o entity manager para comunicação com o banco
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		// faço select das contas
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";

		// abstraio no typed por ser mais especifico passando a conta e o select
		TypedQuery<Conta> sql = em.createQuery(jpql, Conta.class);

		// coloco a informação dentro de um array, trazendo um resultlist do typedquery
		List<Conta> contas = sql.getResultList();

		// percorro a lista para poder imprimir o resultado
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Movimentações: " + conta.getMovimentacoes());
		}
		
		/* Lazy significa que só serão carregados sob demanda */

	}

}