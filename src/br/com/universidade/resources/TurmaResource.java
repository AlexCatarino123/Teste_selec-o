package br.com.universidade.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.universidade.business.TurmaBO;
import br.com.universidade.entity.Turma;

@Path("/turmas")
@Component
public class TurmaResource {
	
	@Autowired
	private TurmaBO turmaBO;
	
	
	@GET
	@Path("/listaTurmas")
	@Produces("application/json")
	public List<Turma> getTurmas() {
		List<Turma> turmas = turmaBO.listaTurmas();
		return turmas;
		
	}

}
