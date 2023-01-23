package com.promineotech.pokemon.service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectReader;
import com.promineotech.pokemon.dao.PokemonOrderDao;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.OrderRequest;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.entity.Pokemon;
import com.promineotech.pokemon.entity.Trainers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PokemonOrderService implements IPokemonOrderService {

  @Autowired
  PokemonOrderDao pokemonOrderDao;
  
  @Override
  public Orders createOrder(OrderRequest orderRequest) {
    BigDecimal price = new BigDecimal(0);
    Trainers trainer = getTrainer(orderRequest);
    
    Pokemon pokemon = getPokemon(orderRequest);
    
    Nature nature = getNature(orderRequest);
    Integer evolutionPhase = getEvolutionPhase(orderRequest);
    
    return pokemonOrderDao.saveOrder(trainer, pokemon, nature, price);
  }

  private int getEvolutionPhase(OrderRequest orderRequest) {
    return pokemonOrderDao.fetchEvolutionPhase(orderRequest.getEvolutionPhase());
  }

  protected Nature getNature(OrderRequest orderRequest) {
    return pokemonOrderDao.fetchNature(orderRequest.getNature())
        .orElseThrow(() -> new NoSuchElementException("Nature with ID=" 
            + orderRequest.getNature() + " was not found"));
  }

  protected Pokemon getPokemon(OrderRequest orderRequest) {
    return pokemonOrderDao.fetchPokemon(orderRequest.getPokemon())
        .orElseThrow(() -> new NoSuchElementException("Pokemon with ID=" 
            + orderRequest.getPokemon() + " was not found"));
  }

  protected Trainers getTrainer(OrderRequest orderRequest) {
        return pokemonOrderDao.fetchTrainer(orderRequest.getTrainerId())
            .orElseThrow(() -> new NoSuchElementException("Trainer with ID=" 
                + orderRequest.getTrainerId() + " was not found"));
  }

}
