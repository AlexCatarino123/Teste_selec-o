package br.com.universidade.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.universidade.dao.AlunoDAO;
import br.com.universidade.dao.CursoDAO;
import br.com.universidade.dao.MatriculaDAO;
import br.com.universidade.dao.TurmaDAO;
import br.com.universidade.entity.Aluno;
import br.com.universidade.entity.Curso;
import br.com.universidade.entity.Matricula;
import br.com.universidade.entity.Turma;

@Controller
public class AlunoBO {
	@Autowired
	private MatriculaDAO matriculaDAO;
	
	@Autowired
	private TurmaDAO turmaDAO;
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@RequestMapping("/salvaAluno")
	public void salvarAluno(Aluno aluno) {
		aluno.setNome("João Victor");
		Matricula matricula = new Matricula();
		matricula.setDescricao(184368L);
		aluno.setMatricula(matricula);
		Curso curso = cursoDAO.buscarCurso(3L);
		aluno.setCurso(curso);
		Turma turma = turmaDAO.buscarTurma(11L);
		aluno.setTurma(turma);
		aluno.setEmail("Joao@gmail.com");
		aluno.setTelefone("88330121");
		
		matriculaDAO.adicionaMatricula(matricula);
		alunoDAO.adicionaAluno(aluno);
	}
	
	public List<Aluno> exibeAlunos(){
		List<Aluno> alunos = alunoDAO.listarAluno();
		return alunos;
		
	}

}
