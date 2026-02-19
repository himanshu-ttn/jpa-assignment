package com.tothenew.jpaassignment.controller;

import com.tothenew.jpaassignment.dto.EmployeeClientDTO;
import com.tothenew.jpaassignment.entities.Employee;
import com.tothenew.jpaassignment.repository.EmployeeRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

//    QUES - 1 ---------------------------------------------------------------------------

    //  1) Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary
    @GetMapping("/emp")
    public ResponseEntity<List<EmployeeClientDTO>> getEmployee() {
        List<EmployeeClientDTO> list = employeeRepository.findEmployeesWithSalaryGreaterThanAverage();
        return ResponseEntity.ok(list);
    }

    //  2) Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary
    @PutMapping("/emp")
    public ResponseEntity<List<Employee>> updateSalaryOfAllEmployeeSalaryLessThanAvgSalary(@RequestParam double salary) {
        List<Employee> list = employeeRepository.findEmployeesWithSalaryLessThanAverage(salary);
        return ResponseEntity.ok(list);
    }

    //    3) Delete all employees with minimum salary.
    @DeleteMapping("/emp")
    public ResponseEntity<String> deleteMinimumSalaryEmployee(@RequestParam double salary) {
        boolean done = employeeRepository.deleteEmployeeWithMinimumSalary(salary);
        return done ? ResponseEntity.ok("Employee deleted successfully") : null;
    }
// --------------------------------------------------------------------------------------

//  Ques 2 ------------------------------------------------------------------------------

    //  1) Display the id, first name, age of all employees where last name ends with "singh"
    @GetMapping("/emp/singh")
    public ResponseEntity<List<Object[]>> getEmployeesWithSingh() {
        List<Object[]> list = employeeRepository.findEmployeesWithSingh();
        return ResponseEntity.ok(list);
    }

    //    2) Delete all employees with age greater than 45(Should be passed as a parameter)
    @DeleteMapping("/emp/del")
    public ResponseEntity<String> deleteAllEmpWithAgeGreaterThan45(@RequestParam int age) {
        boolean done = employeeRepository.deleteByAgeLimitNative(age);
        return done ? ResponseEntity.ok("Employees deleted under age: " + age)
                : ResponseEntity.notFound().build();
    }
//    ----------------------------------------------------------------------------------
}
