package com.tothenew.jpaassignment.entities.onetomany;

import com.tothenew.jpaassignment.entities.Address;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AuthorOTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    //  UNIDIRECTIONAL
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<BookMTO> bookMTOS = new ArrayList<>();

    //  BIDIRECTIONAL
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BookMTO> bookMTOList = new ArrayList<>();

    public void addBook(BookMTO book) {
        bookMTOList.add(book);
        book.setAuthor(this);
    }
}
