package com.example.Individual.Assignment3.Animal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;


/**
 * AnimalController is a REST controller that handles HTTP requests related to
 * animal.
 * It provides endpoints for CRUD operations on animal data.
 */
//@RestController
@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

     /**
   * Endpoint to get all dogs
   *
   * @return List of all dogs
   */

    @GetMapping("/animals")
    public Object getAllAnimals(Model model){
      model.addAttribute("animalList", animalService.getAllAnimals());
      model.addAttribute("title", "All Animals");
      return "animal-list";
    }

      /**
   * Endpoint to get a animal by ID
   *
   * @param id The ID of the animal to retrieve
   * @return The animal with the specified ID
   */

   @GetMapping("/animals/{id}")
   public Object getAnimalById(@PathVariable long id, Model model){
    //return animalService.getAnimalById(id);
    model.addAttribute("animal", animalService.getAnimalById(id));
    model.addAttribute("title", "Animal #: " + id);
    return "animal-details";
   }

    /**
   * Endpoint to get animal by name
   *
   * @param name The name of the animal to search for
   * @return List of animal with the specified name
   */

   @GetMapping("/animals/name")
   public Object getAnimalsByName(@RequestParam String key, Model model){
        if(key != null){
          model.addAttribute("AnimalList", animalService.getAnimalsByName(key));
          model.addAttribute("title", "Animals By Name: " + key);
            return "animal-list";
        }else{
            return "redirect:/animals/";
        }
   }


    /**
   * Endpoint to get animals by breed
   *
   * @param breed The breed to search for
   * @return List of animals with the specified breed
   */

   @GetMapping("/animals/breed/{breed}")
  public Object getAnimalsByBreed(@PathVariable String breed, Model model) {
    //return animalService.getAnimalsByBreed(breed);
    model.addAttribute("animalsList", animalService.getAnimalsByBreed(breed));
    model.addAttribute("title", "Animals By Breed: " + breed);
    return "animal-list";
  }


  @GetMapping("/animals/age")
  public Object getAgeOverTwo(@RequestParam(name = "age", defaultValue = "2") double age){
    return new ResponseEntity<>(animalService.getAgeOverTwo(age), HttpStatus.OK);
  }

  /**
   * Endpoint to show the create form for a new animal
   *
   * @param model The model to add attributes to
   * @return The view name for the create form
   */
  @GetMapping("/animals/createForm")
  public Object showCreateForm(Model model){
    Animal animal = new Animal();
    model.addAttribute("animal", animal);
    model.addAttribute("title", "Create New Animal");
    return "animal-create";
  }

  /**
   * Endpoint to add a new animal
   *
   * @param animal The animal to add
   * @return List of all animals
   */
    @PostMapping("/animals")
    public Object addAnimal(Animal animal, @RequestParam MultipartFile picture){
        //return animalService.addAnimal(animal);
        Animal newAnimal = animalService.addAnimal(animal, picture);
        return "redirect:/animals/" + newAnimal.getDogId();   
       }

      /**
   * Endpoint to show the update form for a animal
   *
   * @param id    The ID of the animal to update
   * @param model The model to add attributes to
   * @return The view name for the update form
   */
  @GetMapping("/animals/updateForm/{id}")
  public Object showUpdateForm(@PathVariable Long id, Model model){
    Animal animal = animalService.getAnimalById(id);
    model.addAttribute("animal", animal);
    model.addAttribute("title", "Update Animal: " + id);
    return "animal-update";
  }

      /**
   * Endpoint to update an animal
   *
   * @param id      The ID of the animal to update
   * @param animal The updated animal information
   * @return The updated animal
   */

   //@PutMapping("/animals/{id}")
   @PostMapping("/animals/update/{id}")
   public Object updateAnimal(@PathVariable Long id, Animal animal, @RequestParam MultipartFile picture){
    animalService.updateAnimal(id, animal, picture);
    return "redirect:/animals/" + id;
   }

   /**
   * Endpoint to delete a animal
   *
   * @param id The ID of the animal to delete
   * @return List of all animals
   */

   //@DeleteMapping("/animals/{id}")
   @GetMapping("/animals/delete/{id}")
   public Object deleteAnimal(@PathVariable Long id){
    animalService.deleteAnimal(id);
    animalService.getAllAnimals();
    return "redirect:/animals/";
   }


   /**
   * Endpoint to write a animal to a JSON file
   *
   * @param animal The animal to write
   * @return An empty string indicating success
   */
   @PostMapping("/animals/writeFile")
   public Object writeJson(@RequestBody Animal animal){
    animalService.writeJson(animal);
    return animalService.writeJson(animal);
   }

     /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/animals/readFile")
  public Object readJson(){
    return animalService.readJson();
  }

}
