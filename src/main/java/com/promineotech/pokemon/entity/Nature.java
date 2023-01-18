package com.promineotech.pokemon.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Nature {
  private Long natureId;
  private String natureName;

}
