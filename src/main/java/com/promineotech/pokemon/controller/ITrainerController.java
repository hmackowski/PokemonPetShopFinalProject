package com.promineotech.pokemon.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.pokemon.entity.Trainers;

@Validated
@RequestMapping("/trainers")
public interface ITrainerController {

  @GetMapping("/all")
  @ResponseStatus(code = HttpStatus.OK)
  List<Trainers> fetchAllTrainers();

  @PostMapping("/addTrainer")
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Trainers> addNewTrainer(
      @RequestParam(required = true) String firstName,
      @RequestParam(required = true) String lastName, 
      @RequestParam(required = true) String hometown);
  
  @DeleteMapping("/deleteTrainer")
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Trainers> deleteTrainer(
      @RequestParam(required = true) Long trainerId);

}
