package br.com.universidade.main;

import br.com.universidade.business.CursoBO;
import br.com.universidade.entity.Curso;

public class CursoCrud {

	public static void main(String[] args) {
		
		Curso curso = new Curso();
		CursoBO bo = new CursoBO();
		
		curso.setNome("Análise e Desenvolvimento de Sistemas");
		
		bo.salvarCurso(curso);

	}

}
