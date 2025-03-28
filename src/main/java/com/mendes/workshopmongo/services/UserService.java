package com.mendes.workshopmongo.services;

import com.mendes.workshopmongo.domain.User;
import com.mendes.workshopmongo.repositories.UserRepository;
import com.mendes.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        if(obj.isEmpty()){
            throw new ObjectNotFoundException("Object not found");
        }
        User user = obj.get();
        return  user;
    }
}
