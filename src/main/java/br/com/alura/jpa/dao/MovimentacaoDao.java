package br.com.alura.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaMovimentacoes() {
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacao", MediaComData.class);
		return query.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {
		String jqpl = "select sum(m.valor) from Movimentacao m ";

		TypedQuery<BigDecimal> query = em.createQuery(jqpl, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();

		return somaDasMovimentacoes;
	}

}