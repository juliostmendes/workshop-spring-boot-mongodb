package com.mendes.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public record CommentDTO(String text, Date date, AuthorDTO author) implements Serializable {
    private static final long SerialVersionUID = 1L;

    public CommentDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }
}
