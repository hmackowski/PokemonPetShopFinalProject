package com.promineotech.pokemon.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.pokemon.dao.ITrainerDao;
import com.promineotech.pokemon.entity.Trainers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TrainerService implements ITrainerService {

  @Autowired
  ITrainerDao trainerDao;
  
  @Override
  public List<Trainers> fetchAllTrainers() {
    log.debug("before Trainer Service returning all trainers");
    List<Trainers> trainers = trainerDao.fetchAllTrainers();
    log.debug("Trainer Service returning all trainers");
    return trainers;
  }

  @Override
  public Optional<Trainers> addNewTrainer(String firstName, String lastName, String hometown) {
    return trainerDao.addnewTrainer(firstName, lastName, hometown);
  }

  @Override
  public Optional<Trainers> deleteTrainer(Long trainerId) {
    log.debug("Deleting Trainer where trainerId={}", trainerId);
    return trainerDao.deleteTrainer(trainerId);
  }



}
