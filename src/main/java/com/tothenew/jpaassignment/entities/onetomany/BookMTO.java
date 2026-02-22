    package com.tothenew.jpaassignment.entities.onetomany;

import jakarta.persistence.*;

@Entity
public class BookMTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;

//    Nothing to do for unidirectional Author(owner) -> Book(child)
//    Parent will have ref to child

//    For Bidirectional mapping :)
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorOTM author;

    public BookMTO(String bookName, AuthorOTM author) {
        this.bookName = bookName;
        this.author = author;
    }

    public AuthorOTM getAuthor() {
        return author;
    }

    public void setAuthor(AuthorOTM author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
