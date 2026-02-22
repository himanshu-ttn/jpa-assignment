package com.tothenew.jpaassignment.repository;

import com.tothenew.jpaassignment.entities.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByAddressLocation(String addressLocation);

    @Modifying
    @Transactional
    void deleteByAddressLocation(String  addressLocation);
}
