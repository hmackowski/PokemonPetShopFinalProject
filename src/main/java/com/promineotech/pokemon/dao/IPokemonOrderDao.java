package com.promineotech.pokemon.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.entity.Pokemon;
import com.promineotech.pokemon.entity.Trainers;;


public interface IPokemonOrderDao {

  Optional<Trainers> fetchTrainer(int trainerId);
  Optional<Pokemon> fetchPokemon(int pokemonId);
  Optional<Nature> fetchColor(Nature pokemonNature);
  Optional <Pokemon> fetchAllPokemon(List<Pokemon> pokemonList);

  
  Orders saveOrder(Long trainerId, int natureId, BigDecimal price);
}
