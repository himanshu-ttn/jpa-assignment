package com.tothenew.jpaassignment.repository;

import com.tothenew.jpaassignment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Q9) Create and use finder to find Employee by Name
    List<Employee> findByName(String firstName);

    // Q10) Create and use finder to find Employees starting with A character
    List<Employee> findByNameStartingWith(String startingName);
    List<Employee> findByNameLike(String likeName);

//    Q11) Create and use finder to find Employees Between the age of 28 to 32
    List<Employee> findByAgeBetween(int min, int max);

}
