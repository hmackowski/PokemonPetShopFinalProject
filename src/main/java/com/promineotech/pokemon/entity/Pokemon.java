package com.promineotech.pokemon.entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pokemon {
  
  @NotNull
  @Positive
  @Min(1)
  @Max(151)
  private Long pokemonId;
  
  private int pokedexNumber;
  private String name;
  private String type1;
  private String type2;
  private int evolutionPhase;
}
