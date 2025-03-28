package com.mendes.workshopmongo.services;

import com.mendes.workshopmongo.domain.Post;
import com.mendes.workshopmongo.repositories.PostRepository;
import com.mendes.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        if(obj.isEmpty()){
            throw new ObjectNotFoundException("Object not found");
        }
        Post post = obj.get();
        return  post;
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
