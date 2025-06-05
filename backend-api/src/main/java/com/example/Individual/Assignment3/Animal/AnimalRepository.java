package com.example.Individual.Assignment3.Animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    List<Animal> getAnimalsByBreed(String breed);

    @Query(value = "select * from animals a where a.age >= ?1 ", nativeQuery = true)
    List<Animal> getAgeOverTwo(double age);

   @Query(value = "SELECT * FROM animals a WHERE a.name ILIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<Animal> getAnimalsByName(String name);
}
