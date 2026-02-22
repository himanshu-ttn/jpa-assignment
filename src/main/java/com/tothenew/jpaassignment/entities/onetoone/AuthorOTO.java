package com.tothenew.jpaassignment.entities.onetoone;


import com.tothenew.jpaassignment.entities.Address;
import com.tothenew.jpaassignment.entities.onetomany.BookMTO;
import jakarta.persistence.*;

@Entity
public class AuthorOTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private BookMTO book;

    public AuthorOTO() {
    }

    public AuthorOTO(String name, Address address, BookMTO book) {
        this.name = name;
        this.address = address;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BookMTO getBook() {
        return book;
    }

    public void setBook(BookMTO book) {
        this.book = book;
    }
}
