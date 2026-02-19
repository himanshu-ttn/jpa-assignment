package com.tothenew.jpaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<com.tothenew.jpaassignment.entities.joined.GameCharacter, Long> {
}
