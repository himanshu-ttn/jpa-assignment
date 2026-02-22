package com.tothenew.jpaassignment.entities.onetoone;

import com.tothenew.jpaassignment.entities.Author;
import jakarta.persistence.*;

@Entity
public class BookOTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;

    @OneToOne(mappedBy = "book")
    private AuthorOTO author;

    public BookOTO() {
    }

    public BookOTO(String bookName, AuthorOTO author) {
        this.bookName = bookName;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public AuthorOTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorOTO author) {
        this.author = author;
    }
}
