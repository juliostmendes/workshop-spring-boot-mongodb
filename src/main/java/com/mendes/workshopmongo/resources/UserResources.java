package com.mendes.workshopmongo.resources;

import com.mendes.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");

         return ResponseEntity.ok().body(Arrays.asList(maria, alex));
    }
}
