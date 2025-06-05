package com.example.Individual.Assignment3.Animal;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository animalRepository;
    private static final String UPLOAD_DIR = "src/main/resources/static/animalPictires/";
  /**
   * Method to get all animals
   *
   * @return List of all animals
   */
    public Object getAllAnimals(){
        return animalRepository.findAll();
    }

      /**
   * Method to get an animal by ID
   *
   * @param dogId The ID of the animal to retrieve
   * @return The animal with the specified ID
   */

   public Animal getAnimalById(@PathVariable long dogId){
    return animalRepository.findById(dogId).orElse(null);
   }

   
  /**
   * Method to get animals by name
   *
   * @param name The name of the animal to search for
   * @return List of animals with the specified name
   */
  public Object getAnimalsByName(String name){
    return animalRepository.getAnimalsByName(name);
  }

 /**
   * Method to get animals by breed
   *
   * @param breed The breed to search for
   * @return List of animals with the specified breed
   */
  public Object getAnimalsByBreed(String breed){
    return animalRepository.getAnimalsByBreed(breed);
  }

  
  /**
   * Fetch all animals with a age above a threshold.
   *
   * @param age the threshold
   * @return the list of matching animals
   */

   public Object getAgeOverTwo(double age){
    return animalRepository.getAgeOverTwo(age);
   }

  /**
   * Method to add a new animal
   *
   * @param animal The animal to add
   */

   public Animal addAnimal(Animal animal, MultipartFile animalPicture){
      Animal newAnimal = animalRepository.save(animal);
      String originalFileName = animalPicture.getOriginalFilename();


      try{
        if(originalFileName != null && originalFileName.contains(".")){
          String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
          String fileName = String.valueOf(newAnimal.getDogId()) + "." + fileExtension;
          Path filePath = Paths.get(UPLOAD_DIR + fileName);

          InputStream inputStream = animalPicture.getInputStream();

          Files.createDirectories(Paths.get(UPLOAD_DIR));
          Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
          newAnimal.setAnimalPicturePath(fileName);
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    return animalRepository.save(animal);
   }

   /**
   * Method to update an animal
   *
   * @param dogId The ID of the animal to update
   * @param animal   The updated animal information
   */

   public Animal updateAnimal(Long dogId, Animal animal, MultipartFile animalPicture){
      String originalFileName = animalPicture.getOriginalFilename();

      try{
        if(originalFileName != null && originalFileName.contains(".")){
          String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
          String fileName = String.valueOf(dogId) + "." + fileExtension;
          Path filePath = Paths.get(UPLOAD_DIR + fileName);

          InputStream inputStream = animalPicture.getInputStream();
          Files.deleteIfExists(filePath);
          Files.copy(inputStream, filePath);
          Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
          animal.setAnimalPicturePath(fileName);
        }
      }catch (Exception e) {
      e.printStackTrace();
    }
      return animalRepository.save(animal);
   }

 /**
   * Method to delete an animal
   *
   * @param dogId The ID of the animal to delete
   */

   public void deleteAnimal(Long dogId){
    Animal animal = animalRepository.findById(dogId).orElse(null);
    if( animal == null){
      return; // Animal not found, nothing to delete
    }    
    Path filePath = Paths.get(UPLOAD_DIR + animal.getAnimalPicturePath());
    try{
      Files.deleteIfExists(filePath);
    }catch (IOException e) {
      e.printStackTrace();
    }
    animalRepository.deleteById(dogId);
   }

   /**
   * Method to write a animal object to a JSON file
   *
   * @param animal The animal object to write
   */

   public String writeJson(Animal animal){
    ObjectMapper objectMapper = new ObjectMapper();
    try{
        objectMapper.writeValue(new File("animals.json"), animal);
        return "Animal written to JSON file successfully";
    }catch(IOException e){
        e.printStackTrace();
        return "Error writing animal to JSON file";
    }
   }


     /**
   * Method to read a animal object from a JSON file
   *
   * @return The animal object read from the JSON file
   */

   public Object readJson(){
    ObjectMapper objectMapper = new ObjectMapper();
    try{
        return objectMapper.readValue(new File("animal.json"), Animal.class);
    }catch (IOException e){
        e.printStackTrace();
        return null;
    }
   }

}
