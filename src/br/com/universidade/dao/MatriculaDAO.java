package br.com.universidade.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.universidade.entity.Matricula;

@Repository
@Transactional
public class MatriculaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void adicionaMatricula(Matricula matricula) {
		entityManager.persist(matricula);
	}

	public Matricula buscaMatricula(Long id) {
		return entityManager.find(Matricula.class, id);
	}

	public void editaMatricula(Matricula matricula) {
		entityManager.merge(matricula);
	}

}
