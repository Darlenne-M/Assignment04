package com.example.Individual.Assignment3.Animal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dogId;
    private String name;
    private String description;
    private String breed;
    private double age;


    public Animal() {

    }

        public Animal(Long dogId, String name, String description, String breed, double age) {
        this.dogId = dogId;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public Animal(String name, String description, String breed, double age) {
        this.dogId = dogId;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public Long getDogId(){
        return dogId;
    }

    public void setDogId(Long id){
        this.dogId = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public double getAge(){
        return age;
    }

    public void setAge(double age){
        this.age = age;
    }

}
