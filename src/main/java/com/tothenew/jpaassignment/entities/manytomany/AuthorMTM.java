package com.tothenew.jpaassignment.entities.manytomany;

import com.tothenew.jpaassignment.entities.Address;
import com.tothenew.jpaassignment.entities.Book;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AuthorMTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "author_book_mtm",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<BookMTM> booksMtmList = new ArrayList<>();


    public AuthorMTM() {
    }

    public AuthorMTM(List<BookMTM> booksMtmList, String name) {
        this.booksMtmList = booksMtmList;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookMTM> getBooksMtmList() {
        return booksMtmList;
    }

    public void setBooksMtmList(List<BookMTM> booksMtmList) {
        this.booksMtmList = booksMtmList;
    }
}
