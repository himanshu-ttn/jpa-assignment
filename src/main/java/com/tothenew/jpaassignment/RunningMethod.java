package com.tothenew.jpaassignment;

import com.tothenew.jpaassignment.entities.Student;
import com.tothenew.jpaassignment.entities.embedable.Address;
import com.tothenew.jpaassignment.entities.joined.Archer;
import com.tothenew.jpaassignment.entities.joined.Warrior;
import com.tothenew.jpaassignment.entities.single_table.Bike;
import com.tothenew.jpaassignment.entities.single_table.Car;
import com.tothenew.jpaassignment.repository.CharacterRepository;
import com.tothenew.jpaassignment.repository.StudentRepository;
import com.tothenew.jpaassignment.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RunningMethod implements ApplicationRunner {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        internalMappingSingleTable();

        internalMappingJoined();


    }

    private void internalMappingSingleTable() {
        Car car = new Car(2, false);
        car.setWheels(4);
        car.setSeats(5);
        car.setSunroof(true);

        Bike bike = new Bike();
        bike.setBrand("Ducati");
        bike.setWheels(2);
        bike.setHasCarrier(false);

        vehicleRepository.save(car);
        vehicleRepository.save(bike);

        vehicleRepository.findAll().forEach(v -> System.out.println(v.getBrand()));
    }

    private void internalMappingJoined() {

        Warrior warrior = new Warrior();
        warrior.setName("Conan");
        warrior.setLevel(45);
        warrior.setLevel(180);
        warrior.setWeaponType("Sword");

        Archer archer = new Archer();
        archer.setName("Legolas");
        archer.setLevel(48);
        archer.setAgility(150);
        archer.setArrowCount(100);

        characterRepository.save(warrior);
        characterRepository.save(warrior);
        characterRepository.save(archer);


    }

    private void saveStudent() {
        // Create the component object
        Address address = new Address("123 Tech Park", "Bangalore", "Karnataka", "560001");

        // Create the Entity object
        Student student = new Student();
        student.setName("Rahul Sharma");
        student.setEmail("rahul@example.com");
        student.setHomeAddress(address); // Nesting the component

        // Save (JPA flattens this into a single INSERT statement)
        studentRepository.save(student);

        System.out.println("Student and Address saved into a single table!");
    }
}
