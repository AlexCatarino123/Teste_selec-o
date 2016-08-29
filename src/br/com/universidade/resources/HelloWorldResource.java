package br.com.universidade.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import br.com.universidade.entity.Curso;

@Path("/helloworld")
public class HelloWorldResource {
	@GET
	@Produces("text/plain")
	public String showHelloWorld() {
		Curso curso = new Curso();
		curso.setId(1L);
		curso.setNome("Farmácia");
		return curso.getNome();
	}

}
