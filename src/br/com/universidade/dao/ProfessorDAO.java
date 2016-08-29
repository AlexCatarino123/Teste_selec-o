package br.com.universidade.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.universidade.entity.Professor;

@Repository
@Transactional
@ComponentScan("br.com.universidade.dao")
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
	
	public List<Professor> listaProfessores() {
		String jpql = "SELECT x FROM Professor x";
		TypedQuery<Professor> consulta = entityManager.createQuery(jpql,Professor.class);
		return consulta.getResultList();
	}

}
