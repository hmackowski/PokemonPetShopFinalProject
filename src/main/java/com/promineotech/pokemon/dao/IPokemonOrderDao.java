package com.promineotech.pokemon.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.entity.Pokemon;
import com.promineotech.pokemon.entity.Trainers;;


public interface IPokemonOrderDao {

  Optional<Trainers> fetchTrainer(String trainer);  

  Optional<Pokemon> fetchPokemon(String pokemon);

  Optional<Nature> fetchNature(String nature);
  
  Orders saveOrder(Trainers trainer,Pokemon pokemon, Nature natures, BigDecimal price);
}
