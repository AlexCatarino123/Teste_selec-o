package br.com.universidade.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.universidade.entity.Curso;

@Repository
@Transactional
@ComponentScan("br.com.universidade.dao")
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
	
	public List<Curso> listaCurso() {
		String jpql = "SELECT x FROM Curso x";
		TypedQuery<Curso> consulta  = entityManager.createQuery(jpql,Curso.class);
		return consulta.getResultList();
	}

}
