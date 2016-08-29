package br.com.universidade.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.universidade.entity.Turma;

@Repository
@Transactional
public class TurmaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void adicionaTurma(Turma turma) {
		entityManager.persist(turma);
	}
	
	public Turma buscarTurma(Long id) {
	    return entityManager.find(Turma.class, id);
	}
	
	public Turma editarTurma(Turma turma) {
		return entityManager.merge(turma);
	}
	
	public List<Turma> listarTurma() {
		String jpql = "SELECT x FROM Turma x ";
		TypedQuery<Turma> consulta = entityManager.createQuery(jpql,Turma.class);
		return consulta.getResultList();
	}

}
