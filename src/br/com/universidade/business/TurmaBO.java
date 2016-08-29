package br.com.universidade.business;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.universidade.dao.ProfessorDAO;
import br.com.universidade.dao.TurmaDAO;
import br.com.universidade.entity.Professor;
import br.com.universidade.entity.Turma;

@Controller
public class TurmaBO {
	
	@Autowired
	private TurmaDAO turmaDAO;
	
	@Autowired
	private ProfessorDAO  professorDAO;
	
	
	@RequestMapping("/adicionaTurma")
	public String salvaTurma(Turma turma) {
		turma.setSigla("T203-457");
		turma.setData(new GregorianCalendar(2014,8,01));
		Professor professor = new Professor();
		professor = professorDAO.buscaProfessor(8L);
		turma.setProfessor(professor);
		turmaDAO.adicionaTurma(turma);
		return "sucesso";
		
	}
	@RequestMapping("/editaTurma")
	public String editaTurma(Turma turma) {
	    turma = turmaDAO.buscarTurma(11L);
	    turma.setSigla("T101-457");
		turma.setData(new GregorianCalendar(2016,9,01));
		Professor professor = new Professor();
		professor = professorDAO.buscaProfessor(8L);
		turma.setProfessor(professor);
		turmaDAO.editarTurma(turma);
		return "sucesso";
	    
		
	}
	
	public List<Turma> listaTurmas() {
		List<Turma> turmas = turmaDAO.listarTurma();
		return turmas;
	}
	
	
	

}
