package com.tothenew.jpaassignment;

import com.tothenew.jpaassignment.entities.Address;
import com.tothenew.jpaassignment.entities.Author;
import com.tothenew.jpaassignment.entities.Book;
import com.tothenew.jpaassignment.repository.AuthorRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JpaAssignmentApplication implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    private List<String> namesList = List.of("Sonu", "Monu", "Nonu", "Raju", "Paju");
    private List<String> subjectsList = List.of("Horror", "Math", "Biology", "Economics", "Dark", "Who decided that");
    private List<Address> addressesList = List.of(
            new Address("12A", "MG Road, Indiranagar", "Karnataka"),
            new Address("45B", "Park Street, Taltala", "West Bengal"),
            new Address("78", "Anna Salai, Teynampet", "Tamil Nadu"),
            new Address("101C", "Linking Road, Bandra West", "Maharashtra"),
            new Address("22", "Sector 17, Chandigarh", "Punjab")
    );

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaAssignmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        int entriesToEnter = 1;

        //  Q4.  Persist 3 subjects for each author.
        for (int i = 0; i < entriesToEnter; i++) {
            authorRepository.save(AddRandomAuthor());
        }
    }

    /**
     * Q1. Create a class Address for Author with instance variables streetNumber, location, State.
     * <br/>
     * Q2.	Create instance variable of Address class inside Author class and save it as embedded object.
     * <br/>
     * Q3.  Introduce a List of subjects for author.
     */
    private Author AddRandomAuthor() {

        int NumOfSubject = 5;

        // setting the author with name and address from the list : Random
        Author author = new Author(
                namesList.get((int) (Math.random() * namesList.size())),
                addressesList.get((int) (Math.random() * addressesList.size()))
        );

        int randomLength = (int) (Math.random() * NumOfSubject);

        // setting subject of random length for the author :)
        for (int i = 0; i < randomLength; i++) {
            author.getSubjects().add(subjectsList.get((int) (Math.random() * subjectsList.size())));
        }

        return author;
    }


    /**
     *  Q9.Which method on the session object can be used to remove an object from the cache?
     * <br/>
     * Ans. To remove a specific object form the Hibernate Session cache we use the <b> <i>evict()</i> </b>
     */
    private void AnswerForQues9(){

    }
}
