package br.com.universidade.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import br.com.universidade.business.CursoBO;
import br.com.universidade.dao.CursoDAO;
import br.com.universidade.entity.Curso;

@Path("/cursos")
@Component
@ComponentScan("br.com.universidade.resources")
public class CursoResource {
	

	@Autowired
	private CursoBO cursoBO;
	
	
	@GET
	@Path("/listarCursos")
	@Produces("application/json")
	public List<Curso> getCursos() {
		System.out.println("Entrou no método");
		List<Curso> cursos = cursoBO.exibeCursos();
		
		return cursos;
		
	}
	
	@POST
	@Path("/novoCurso")
	@Consumes("text/xml")
	@Produces("application/json")
	public void adicionaCurso(Curso curso) {
		cursoBO.salvarCurso(curso);
	}
	
	
	
	

}
