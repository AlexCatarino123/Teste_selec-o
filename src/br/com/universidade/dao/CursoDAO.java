package br.com.universidade.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.universidade.entity.Curso;

@Repository
@Transactional
public class CursoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void adicionaCurso(Curso curso) {
		entityManager.persist(curso);
	}

	public Curso buscarCurso(Long id) {
		return entityManager.find(Curso.class, id);
	}

	public void editarCurso(Curso curso) {
		entityManager.merge(curso);
	}

}
