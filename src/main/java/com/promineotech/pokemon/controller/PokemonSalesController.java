package com.promineotech.pokemon.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;
import com.promineotech.pokemon.service.IPokemonSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PokemonSalesController implements IPokemonSalesController {

  @Autowired
  private IPokemonSalesService pokemonSalesService;

  @Override
  public List<Pokemon> fetchPokemon(Integer pokemonId) {
    log.debug("it is working");
    return pokemonSalesService.fetchPokemon(pokemonId);
  }

  @Override
  public List<Nature> fetchAllPokemon() {
    log.debug("Returning all natures");
    return pokemonSalesService.fetchAllNatures();
  }

  
}
