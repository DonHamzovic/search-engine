package org.securme.jwt;

import org.securme.jwt.dao.TaskRepository;
import org.securme.jwt.entities.AppRole;
import org.securme.jwt.entities.AppUser;
import org.securme.jwt.entities.Task;
import org.securme.jwt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages ={"org.securme.jwt"})
public class JwtApplication  implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    public void run(String... args) throws Exception {

        accountService.saveUser(new AppUser(null,"admin","123",null));
        accountService.saveUser(new AppUser(null,"user","123",null));

        accountService.saveRole(new AppRole(null,"ADMIN"));
        accountService.saveRole(new AppRole(null,"USER"));

        accountService.AddRoleToUser("admin","ADMIN");
        accountService.AddRoleToUser("admin","USER");

        Stream.of("Task1","Task2","Task3","Task4").forEach(t->{
            taskRepository.save( new Task( t));
        });

        taskRepository.findAll().forEach(t->{
             System.out.println(t.getTaskName());
        });
    }
}
