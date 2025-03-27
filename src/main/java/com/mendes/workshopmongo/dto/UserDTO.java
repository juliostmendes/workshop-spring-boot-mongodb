package com.mendes.workshopmongo.dto;

import com.mendes.workshopmongo.domain.User;

import java.io.Serializable;

public record UserDTO(String id, String name, String email) implements Serializable {
    private static final long serialVersionUID = 1L;

    public UserDTO(User obj) {
        this(obj.getId(), obj.getName(), obj.getEmail());
    }
}
