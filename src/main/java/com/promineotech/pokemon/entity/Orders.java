package com.promineotech.pokemon.entity;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {
  private Long orderId;
  private Trainers trainerId;
  private Nature natureId;
  private BigDecimal price;
  //private DateTime
}
