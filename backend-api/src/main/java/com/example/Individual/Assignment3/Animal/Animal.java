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
    private String animalPicturePath;


    public Animal() {

    }

        public Animal(Long dogId, String name, String description, String breed, double age, String animalPicturePath) {
        this.dogId = dogId;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
        this.animalPicturePath = animalPicturePath;
    }

    public Animal(String name, String description, String breed, double age, String animalPicturePath) {
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
        this.animalPicturePath = animalPicturePath;
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

    public String getAnimalPicturePath(){
        return animalPicturePath;
    }

    public void setAnimalPicturePath(String animalPicturePath){
        this.animalPicturePath = animalPicturePath;
    }
}
