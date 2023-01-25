package com.promineotech.pokemon.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonOrder {

  private Long pokemonOrderId;
  private Orders orders;
  private Pokemon pokemon;
}
