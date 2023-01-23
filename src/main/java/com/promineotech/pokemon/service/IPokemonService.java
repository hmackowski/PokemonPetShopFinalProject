package com.promineotech.pokemon.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;

public interface IPokemonService {

  /**
   * 
   * @param pokemonId
   * @return
   */
  List<Pokemon> fetchPokemon(Integer pokemonId);

  List<Nature> fetchAllNatures();

  List<Pokemon> fetchAllPokemon();

  Optional<Pokemon> addPokemon(int pokedexNumber, String name, String type1, String type2,
      int evolutionPhase);

  Optional<Pokemon> updatePokemon(Long pokemonId, int pokedexNumber, String name, String type1,
      String type2, int evolutionPhase);

  Optional<Pokemon> deletePokemon(Long pokemonId);

}
