package br.com.universidade.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.universidade.business.AlunoBO;
import br.com.universidade.entity.Aluno;


@Path("/alunos")
@Component
public class AlunoResource {
	
	@Autowired
	private AlunoBO alunoBO;
	
	@GET
	@Path("/listaAlunos")
	@Produces("application/json")
	public List<Aluno> getAlunos() {
		List<Aluno> alunos = alunoBO.exibeAlunos();
		return alunos;
	}
	

}
