package com.promineotech.pokemon.service;

import java.util.List;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;

public interface IPokemonSalesService {

  /**
   * 
   * @param pokemonId
   * @return
   */
  List<Pokemon> fetchPokemon(Integer pokemonId);

  List<Nature> fetchAllNatures();

}
