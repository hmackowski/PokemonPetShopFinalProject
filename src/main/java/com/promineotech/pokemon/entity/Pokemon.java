package com.promineotech.pokemon.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pokemon {
  private Long pokemonId;
  private int pokedexNumber;
  private String name;
  private String type1;
  private String type2;
  private int evolutionPhase;
}
