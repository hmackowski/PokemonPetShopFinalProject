package com.promineotech.pokemon.service;


import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.pokemon.dao.PokemonOrderDao;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.OrderRequest;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.entity.Pokemon;
import com.promineotech.pokemon.entity.PokemonOrder;
import com.promineotech.pokemon.entity.Trainers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PokemonOrderService implements IPokemonOrderService {

  @Autowired
  PokemonOrderDao pokemonOrderDao;

  @Override  // Creates order using fields in the orderRequest Class
  public Orders createOrder(OrderRequest orderRequest) {
    double price;
    Trainers trainer = getTrainer(orderRequest);

    Pokemon pokemon = getPokemon(orderRequest);

    int pokemonEvo = pokemonOrderDao.fetchEvolutionPhase(orderRequest.getPokemon());
    
    price = pokemonEvo * 500;
    Nature nature = getNature(orderRequest);

    return pokemonOrderDao.saveOrder(trainer, pokemon, nature, price);
  }

// Fetches nature from the orderRequest field
  protected Nature getNature(OrderRequest orderRequest) {
    return pokemonOrderDao.fetchNature(orderRequest.getNature())
        .orElseThrow(() -> new NoSuchElementException(
            "Nature with ID=" + orderRequest.getNature() + " was not found"));
  }
//Fetches Pokemon from the orderRequest field
  protected Pokemon getPokemon(OrderRequest orderRequest) {
    return pokemonOrderDao.fetchPokemon(orderRequest.getPokemon())
        .orElseThrow(() -> new NoSuchElementException(
            "Pokemon with ID=" + orderRequest.getPokemon() + " was not found"));
  }

//Fetches Trainer from the orderRequest field
  protected Trainers getTrainer(OrderRequest orderRequest) {
    return pokemonOrderDao.fetchTrainer(orderRequest.getTrainerId())
        .orElseThrow(() -> new NoSuchElementException(
            "Trainer with ID=" + orderRequest.getTrainerId() + " was not found"));
  }


  @Override // Pulls order given pokemonOrderId number
  public List<PokemonOrder> pullOrder(String pokemonOrderId) {
    log.debug("Returning an order where orderID={}", pokemonOrderId);
    return pokemonOrderDao.pullOrder(pokemonOrderId);
  }

}
