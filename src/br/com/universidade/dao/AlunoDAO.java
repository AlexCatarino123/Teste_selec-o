package br.com.universidade.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.universidade.entity.Aluno;

@Repository
@Transactional
public class AlunoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void adicionaAluno (Aluno aluno) {
		entityManager.persist(aluno);
		
	}
	
	public Aluno buscarAluno(Long id) {
		return entityManager.find(Aluno.class, id);
	}
	
	public Aluno editarAluno(Aluno aluno) {
		return entityManager.merge(aluno);
	}
	
	public List<Aluno> listarAluno() {
		String jpql = "SELECT x FROM Aluno x ";
		TypedQuery<Aluno> consulta = entityManager.createQuery(jpql,Aluno.class);
		return consulta.getResultList();
	}
	

}
