package com.tothenew.jpaassignment.repository;

import com.tothenew.jpaassignment.dto.EmployeeClientDTO;
import com.tothenew.jpaassignment.entities.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//  Q1) JPQL: Instructions:
//      A) Create an employeeTable table with the following fields: empId, empFirstName, empLastName, empSalary, empAge.
//      B) Create an Employee entity having following fields: id, firstName, lastName, salary, age which maps to the table columns given in above.
//      Questions: 1) Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
//      2) Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
//      3) Delete all employees with minimum salary.
    @Query("""
            Select e.firstName, e.lastName
            from Employee e
            where e.salary > (Select avg(salary) from Employee)
            Order By e.age ASC, e.salary DESC
            """)
    List<EmployeeClientDTO> findEmployeesWithSalaryGreaterThanAverage();

    @Query("""
            UPDATE Employee e
            SET e.salary = :newSalary
            WHERE e.salary < (Select AVG(emp.salary) FROM Employee emp)
            """)
    List<Employee> findEmployeesWithSalaryLessThanAverage(@Param("newSalary") double newSalary);

    @Query("""
            DELETE FROM Employee e
            WHERE e.salary  = (SELECT MIN(emp.salary) FROM Employee emp)
            """)
    boolean deleteEmployeeWithMinimumSalary(@Param("newSalary") double newSalary);

// Q2. Native Query: Instructions:
//      A) Create an employeeTable table with the following fields: empId, empFirstName, empLastName, empSalary, empAge.
//      B) Create an Employee entity having following fields: id, firstName, lastName, salary, age which maps to the table columns given in above.
//      Questions: 1) Display the id, first name, age of all employees where last name ends with "singh"
//      2) Delete all employees with age greater than 45(Should be passed as a parameter)

    @Query(value = "SELECT empId, empFirstName, empAge From employeeTable WHERE empLastName LIKE '%singh%'", nativeQuery = true )
    List<Object[]> findEmployeesWithSingh();

    @Query(value = "DELETE FROM employeeTable WHERE empAge > :ageLimit",
            nativeQuery = true)
    boolean deleteByAgeLimitNative(@Param("ageLimit") Integer ageLimit);
}
