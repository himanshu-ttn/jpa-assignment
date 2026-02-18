package com.tothenew.jpaassignment.controller;

import com.tothenew.jpaassignment.model.Employee;
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

    //    Q3) Perform Create Operation on Entity using Spring Data JPA
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    //    Q4) Perform Update Operation on Entity using Spring Data JPA
    @PutMapping("/")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee newEmployee) {

        // :: First finding and thne modifying and then updating
        Optional<Employee> found = employeeRepository.findById(newEmployee.getId());

        return found.map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setLocation(newEmployee.getLocation());
            employee.setAge(newEmployee.getAge());

            Employee updated = employeeRepository.save(employee);
            return ResponseEntity.ok(updated);

        }).orElse(ResponseEntity.notFound().build());
    }


    //    Q5) Perform Delete Operation on Entity using Spring Data JPA
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {

//        simple checking if exits or not and if exist then delete the employee :)
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok("Employee deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }

    //    Q6) Perform Read Operation on Entity using Spring Data JPA
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    //  Q7) Get the total count of the number of Employees
    @GetMapping("/count")
    public ResponseEntity<Long> countEmployees() {
        return ResponseEntity.ok(employeeRepository.count());
    }

    // Q8) Implement Pagination and Sorting on the bases of Employee Age
    @GetMapping("/page")
    public ResponseEntity<Page<Employee>> getAllEmployeesByAgeSort(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size,
            @RequestParam(defaultValue = "asc") String order) {

        String ageField = "age";

        Sort sort = order.equalsIgnoreCase("desc") ?
                Sort.by(Sort.Direction.DESC, ageField) :
                Sort.by(ageField).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return ResponseEntity.ok(employees);
    }

//    Q9) Create and use finder to find Employee by Name
    @GetMapping("/find")
    public ResponseEntity<List<Employee>> getAllEmployeesByName(@RequestParam String name) {
        List<Employee> employees = employeeRepository.findByName(name);
        return ResponseEntity.ok(employees);
    }


//    Q10) Create and use finder to find Employees starting with A character
    @GetMapping("/check")
    public ResponseEntity<List<Employee>> getAllEmployeeNameStartWithA(@RequestParam(defaultValue = "A") String name) {

//        Both ways can be done :)
//        List<Employee> list =  employeeRepository.findByNameLike("%"+name+"%");
        List<Employee> list =  employeeRepository.findByNameStartingWith(name);
        return ResponseEntity.ok(list);
    }

// Q11) Create and use finder to find Employees Between the age of 28 to 32
    @GetMapping("/age")
    public ResponseEntity<List<Employee>> getAllEmployeeAgeBetween(@RequestParam(defaultValue = "28") Integer min, @RequestParam(defaultValue = "32") Integer max) {
        List<Employee> list = employeeRepository.findByAgeBetween(min, max);
        return ResponseEntity.ok(list);
    }
}
