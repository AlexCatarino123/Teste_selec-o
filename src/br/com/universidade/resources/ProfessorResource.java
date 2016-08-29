package br.com.universidade.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.com.universidade.business.ProfessorBO;
import br.com.universidade.entity.Professor;

@Path("/professores")
@Component
public class ProfessorResource {
	
	@Autowired
	private ProfessorBO professorBO;
	
	@GET
	@Path("/listaProfessores")
	@Produces("application/json")
	public List<Professor> getProfessores() {
		List<Professor> professores = professorBO.exibeProfessores();
		return professores;
		
	}

}
