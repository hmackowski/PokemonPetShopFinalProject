package com.promineotech.pokemon.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;
import com.promineotech.pokemon.service.IPokemonService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PokemonController implements IPokemonController {

  @Autowired
  private IPokemonService pokemonService;
  

  @Override
  public List<Pokemon> fetchPokemon(Integer pokemonId) {
    log.debug("Fetching pokemon where pokemonID={}", pokemonId);
    return pokemonService.fetchPokemon(pokemonId);
  }

  @Override
  public List<Nature> fetchAllNatures() {
    log.debug("fetchAllNatures() was called, returns a list of all Natures.");
    return pokemonService.fetchAllNatures();
  }

  @Override
  public List<Pokemon> fetchAllPokemon() {
    log.debug("Returning a list of all Pokemon.");
    return pokemonService.fetchAllPokemon();
  }

  @Override
  public Optional<Pokemon> addPokemon(int pokedexNumber, String name, String type1, String type2,
      int evolutionPhase) {
    log.debug("Adding new Pokemon pokedexNumber={}, name={}, type1={}, type2={}, evolutionPhase={}",
        pokedexNumber, name, type1, type2, evolutionPhase);
    return pokemonService.addPokemon(pokedexNumber, name, type1, type2, evolutionPhase);
      }

  @Override
  public Optional<Pokemon> updatePokemon(Long pokemonId, int pokedexNumber, String name,
      String type1, String type2, int evolutionPhase) {
    log.debug("Updating Pokemon Where pokemonID={}", pokemonId);
    return pokemonService.updatePokemon(pokemonId, pokedexNumber, name, type1, type2, evolutionPhase);
  }

  @Override
  public Optional<Pokemon> deletePokemon(Long pokemonId) {
    log.debug("Deleting Pokemon Where pokemonID={}", pokemonId);
    return pokemonService.deletePokemon(pokemonId);
  }


  
}
