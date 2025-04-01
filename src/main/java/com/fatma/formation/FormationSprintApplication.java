package com.fatma.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.fatma.formation.entities.Formation;

@SpringBootApplication
@ComponentScan(basePackages = "com.fatma.formation")
public class FormationSprintApplication implements CommandLineRunner {

	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(FormationSprintApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Formation.class);
	}

}
