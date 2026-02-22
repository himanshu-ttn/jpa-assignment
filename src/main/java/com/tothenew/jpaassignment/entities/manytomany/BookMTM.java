package com.tothenew.jpaassignment.entities.manytomany;

import com.tothenew.jpaassignment.entities.Author;
import com.tothenew.jpaassignment.entities.onetomany.AuthorOTM;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BookMTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;

    @ManyToMany(mappedBy = "booksMtmList")
    private List<AuthorOTM> authorOTMList;

    public BookMTM() {
    }

    public BookMTM(String bookName, List<AuthorOTM> authorOTMList) {
        this.bookName = bookName;
        this.authorOTMList = authorOTMList;
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

    public List<AuthorOTM> getAuthorOTMList() {
        return authorOTMList;
    }

    public void setAuthorOTMList(List<AuthorOTM> authorOTMList) {
        this.authorOTMList = authorOTMList;
    }
}
