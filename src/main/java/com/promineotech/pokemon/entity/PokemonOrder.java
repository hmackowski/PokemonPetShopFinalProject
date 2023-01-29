package com.promineotech.pokemon.entity;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonOrder {

  private String pokemonOrderId;
  private String trainerFirstName;
  private String trainerLastName;
  private String pokemonName;
  private String nature;
  private String orderPrice;
  private String dateTime;
 // private List<String> pokemons;


}
