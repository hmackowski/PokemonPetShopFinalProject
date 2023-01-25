package com.promineotech.pokemon.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {
  private Long orderId;
  private Trainers trainerId;
  private Nature natureId;
  private double price;
  //private DateTime
  
  public Long getOrderId() {
    return orderId;
  }
}
