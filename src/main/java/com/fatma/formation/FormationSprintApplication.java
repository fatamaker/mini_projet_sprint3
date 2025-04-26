package com.fatma.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fatma.formation.entities.Formation;
import com.fatma.formation.entities.Role;
import com.fatma.formation.entities.User;
import com.fatma.formation.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fatma.formation", "com.fatma.config"})
public class FormationSprintApplication implements CommandLineRunner {

	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService ;
	
	public static void main(String[] args) {
		SpringApplication.run(FormationSprintApplication.class, args);
	}
	
	/*
	 * @PostConstruct void init_users() { //ajouter les rôles
	 * userService.addRole(new Role(null,"ADMIN")); userService.addRole(new
	 * Role(null,"AGENT")); userService.addRole(new Role(null,"USER")); //ajouter
	 * les users userService.saveUser(new User(null,"admin","123",true,null));
	 * userService.saveUser(new User(null,"nadhem","123",true,null));
	 * userService.saveUser(new User(null,"user1","123",true,null)); //ajouter les
	 * rôles aux users userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("nadhem", "USER");
	 * userService.addRoleToUser("nadhem", "AGENT");
	 * userService.addRoleToUser("user1", "USER"); }
	 */
	
	@Override
	public void run(String... args) throws Exception {

	//System.out.println("Password Encoded BCRYPT :******************** ");
	//System.out.println(passwordEncoder.encode("123"));
		
	repositoryRestConfiguration.exposeIdsFor(Formation.class);

	}
	

}
