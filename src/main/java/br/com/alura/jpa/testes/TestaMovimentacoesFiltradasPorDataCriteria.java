package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacoesFiltradasPorDataCriteria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(em);
		List<Movimentacao> movimentacoesFiltradas = dao.getMovimentacoesFiltradasPorData(null, null, null);

		for (Movimentacao movimentacao : movimentacoesFiltradas) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("------------------------------------------- ");
		}
	}

}