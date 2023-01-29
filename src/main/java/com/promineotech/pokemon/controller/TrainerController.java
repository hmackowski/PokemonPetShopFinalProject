package com.promineotech.pokemon.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.pokemon.entity.Trainers;
import com.promineotech.pokemon.service.ITrainerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TrainerController implements ITrainerController {
  
  @Autowired  
  ITrainerService trainerService;
  
  @Override   //Fetches all trainers in the trainers table
  public List<Trainers> fetchAllTrainers() {
    log.debug("Returning a list of all Trainers.");
    return trainerService.fetchAllTrainers();
  }

  @Override  // Adds a new trainer to the trainers table
  public Optional<Trainers> addNewTrainer(String firstName, String lastName, String hometown) {
    return trainerService.addNewTrainer(firstName, lastName, hometown);
  }

  @Override  // Deletes a trainer from the trainers table
  public Optional<Trainers> deleteTrainer(Long trainerId) {
    return trainerService.deleteTrainer(trainerId);
  }

 
  

}
