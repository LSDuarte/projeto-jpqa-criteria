package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaSomaDasMovimentacoesComCriteriaQuery {

	public static void main(String[] args) {

		// API que permite escrever QUERY orientada a objetos.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);

		// raiz da movimentação
		Root<Movimentacao> root = query.from(Movimentacao.class);

		// função select sum(m.valor) do sql
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));

		// select
		query.select(sum);

		// transforma em typedQuery
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);

		BigDecimal somaDasMovimentacoes = typedQuery.getSingleResult();

		System.out.println("Soma das movimentações: R$" + somaDasMovimentacoes);

	}

}