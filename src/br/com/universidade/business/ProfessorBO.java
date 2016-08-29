package br.com.universidade.business;

import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.universidade.dao.CursoDAO;
import br.com.universidade.dao.MatriculaDAO;
import br.com.universidade.dao.ProfessorDAO;
import br.com.universidade.entity.Curso;
import br.com.universidade.entity.Matricula;
import br.com.universidade.entity.Professor;

@Controller
@ComponentScan("br.com.universidade.business")
public class ProfessorBO {
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@Autowired
	private MatriculaDAO matriculaDAO;
	
	@Autowired
	private CursoDAO cursoDAO;
	
	Scanner entrada = new Scanner(System.in);
	@RequestMapping("/salvaProfessor")
	private String salvarProfessor(Professor professor) {
		System.out.println("Digite o nome do professor:");
		professor.setNome(entrada.nextLine());
		
		System.out.println("Digite a matrícula do professor:");
		Matricula matricula = new Matricula();
		matricula.setDescricao(Long.parseLong(entrada.nextLine()));
		professor.setMatricula(matricula);
		
		System.out.println("Digite o id do curso que o professor irá lecionar:");
		Long id = Long.parseLong(entrada.nextLine());
		Curso curso = cursoDAO.buscarCurso(id);
		professor.setCurso(curso);
		
		System.out.println("Digite o email do professor:");
		professor.setEmail(entrada.nextLine());
		
		System.out.println("Digite o telefone do professor:");
		professor.setTelefone(Long.parseLong(entrada.nextLine()));
		
		
		entrada.close();
		
		matriculaDAO.adicionaMatricula(matricula);
		professorDAO.adicionaProfessor(professor);
		
		return "sucesso";
		
		
		
	}

}
