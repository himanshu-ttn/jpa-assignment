package com.tothenew.jpaassignment.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "author_subjects", joinColumns = @JoinColumn(name = "author_id"))
    @Column(name = "subject_name")
    private List<String> subjects = new ArrayList<>();


    //  Q6. Implement One to One mapping between Author and Book.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    //  Q7. Implement One to Many Mapping between Author and Book(Unidirectional, BiDirectional and without additional table ) and implement cascade save.
//    ## Without table
    @OneToMany(cascade = CascadeType.PERSIST)
    // Prevents a separate join table
    private List<Book> books = new ArrayList<>();


    //
    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Book> oneToManyBooks = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "author_book_mapping",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> bookMapping = new ArrayList<>();


    public Author() {
    }

    public Author(String name, Address address) {
        this.name = name;
        this.address = address;
    }

//   :: GETTERS & SETTERS ::


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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getOneToManyBooks() {
        return oneToManyBooks;
    }

    public void setOneToManyBooks(List<Book> oneToManyBooks) {
        this.oneToManyBooks = oneToManyBooks;
    }

    public List<Book> getBookMapping() {
        return bookMapping;
    }

    public void setBookMapping(List<Book> bookMapping) {
        this.bookMapping = bookMapping;
    }
}
