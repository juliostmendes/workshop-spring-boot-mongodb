package com.mendes.workshopmongo.config;

import com.mendes.workshopmongo.domain.User;
import com.mendes.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Carl Smith", "carlsmith@gmail.com");
        User u3 = new User(null, "William DaFoe", "willdafoe@gmail.com");

        repository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
