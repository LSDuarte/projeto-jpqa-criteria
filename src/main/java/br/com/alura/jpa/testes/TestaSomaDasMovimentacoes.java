package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(em);
		BigDecimal somaValores = dao.getSomaDasMovimentacoes();

		System.out.println("Soma das movimentações: R$" + somaValores);

	}

}