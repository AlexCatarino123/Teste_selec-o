package br.com.universidade.business;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.universidade.dao.CursoDAO;
import br.com.universidade.entity.Curso;

@Controller
public class CursoBO {
	
	Scanner entrada = new Scanner(System.in);
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@RequestMapping("/salvaCurso")
	public String salvarCurso(Curso curso) {
		System.out.println("Executando Lógica...");
		System.out.println("Digite o nome do curso:");
		curso.setNome(entrada.nextLine());
		entrada.close();
		cursoDAO.adicionaCurso(curso);
		return "sucesso";
		
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

}
