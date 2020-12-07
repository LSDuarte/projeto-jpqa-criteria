package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.MediaComData;

public class TestaMediaDiariaDasProjecao {

	public static void main(String[] args) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		List<MediaComData> mediaValores = new MovimentacaoDao(em).getMediaDiariaMovimentacoes();

		for (MediaComData resultado : mediaValores) {
			System.out.println("Média dos valores do dia " + resultado.getData() + "/" + resultado.getMes() + " é: "
					+ resultado.getMedia());
		}

	}

}