package br.com.universidade.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsereTabelas {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Universidade_pu");
		
		factory.close();

	}

}
