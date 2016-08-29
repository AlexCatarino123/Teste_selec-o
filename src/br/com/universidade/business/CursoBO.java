package br.com.universidade.business;


import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.universidade.dao.CursoDAO;
import br.com.universidade.entity.Curso;

@Controller
@ComponentScan("br.com.universidade.business")
public class CursoBO {
	
	Scanner entrada = new Scanner(System.in);
	
	@Autowired
	private CursoDAO cursoDAO;
	
	
	public void salvarCurso(Curso curso) {
		cursoDAO.adicionaCurso(curso);
		
	}
	
	@RequestMapping("/editaCurso")
	public String editaCurso() {
		System.out.println("Digite o id do Curso a ser editado:");
		Long id = Long.parseLong(entrada.nextLine()); 
		Curso curso = cursoDAO.buscarCurso(id);
		System.out.println("Digite o novo nome do Curso:");
		curso.setNome(entrada.nextLine());
		cursoDAO.editarCurso(curso);
		entrada.close();
		return "sucesso";
		
	}
	
	public List<Curso> exibeCursos() {
		List<Curso> cursos = cursoDAO.listaCurso();
		return cursos;
	    
	    
		
	}

}
