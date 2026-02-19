package com.tothenew.jpaassignment;

import com.tothenew.jpaassignment.entities.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Arrays;

@SpringBootApplication
public class JpaAssignmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaAssignmentApplication.class, args);
    }

}
