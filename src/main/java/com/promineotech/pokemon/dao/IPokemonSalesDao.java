package com.promineotech.pokemon.dao;

import java.util.List;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;

public interface IPokemonSalesDao {

  List<Pokemon> fetchPokemon(Integer pokemonId);

  List<Nature> fetchAllNatures();
}
