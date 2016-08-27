package br.com.universidade.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.universidade.entity.Professor;

@Repository
@Transactional
public class ProfessorDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void adicionaProfessor(Professor professor) {
		entityManager.persist(professor);
	}

	public Professor buscaProfessor(Long id) {
		return entityManager.find(Professor.class, id);
	}
	
	public void editaProfessor(Professor professor) {
		entityManager.merge(professor);
	}

}
