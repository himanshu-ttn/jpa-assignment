package com.tothenew.jpaassignment.repository;

import com.tothenew.jpaassignment.entities.single_table.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
