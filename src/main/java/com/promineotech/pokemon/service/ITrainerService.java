package com.promineotech.pokemon.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.pokemon.entity.Trainers;

public interface ITrainerService {

  List<Trainers> fetchAllTrainers();

  Optional<Trainers> addNewTrainer(String firstName, String lastName, String hometown);

  Optional<Trainers> deleteTrainer(Long trainerId);

}
