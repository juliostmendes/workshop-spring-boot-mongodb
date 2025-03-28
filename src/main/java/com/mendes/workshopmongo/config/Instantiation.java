package com.mendes.workshopmongo.config;

import com.mendes.workshopmongo.domain.Post;
import com.mendes.workshopmongo.domain.User;
import com.mendes.workshopmongo.dto.AuthorDTO;
import com.mendes.workshopmongo.dto.CommentDTO;
import com.mendes.workshopmongo.repositories.PostRepository;
import com.mendes.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Carl Smith", "carlsmith@gmail.com");
        User u3 = new User(null, "William DaFoe", "willdafoe@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(null, sdf.parse("2025-01-12") , "How to center a div?", "It look like it's impossible", new AuthorDTO(u1));
        Post p2 = new Post(null, sdf.parse("2025-01-12") , "Are Brazil dangerous?", "I think that I'll go to Brazil", new AuthorDTO(u1));

        CommentDTO c1 = new CommentDTO("I don't know", sdf.parse("2025-02-10"), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("Maybe with CSS", sdf.parse("2025-02-12"), new AuthorDTO(u3));
        CommentDTO c3 = new CommentDTO("Not so much", sdf.parse("2025-03-10"), new AuthorDTO(u3));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(u1);
    }
}
