package com.promineotech.pokemon.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.pokemon.entity.Trainers;

public interface ITrainerDao {

  List<Trainers> fetchAllTrainers();

  Optional<Trainers> addnewTrainer(String firstName, String lastName, String hometown);

  Optional<Trainers> deleteTrainer(Long trainerId);

}
