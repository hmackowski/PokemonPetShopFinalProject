package com.promineotech.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.pokemon.entity.OrderRequest;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.service.IPokemonOrderService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PokemonOrderController implements IPokemonOrderController {

  @Autowired
  IPokemonOrderService pokemonOrderService;

  @Override
  public Orders createOrder(OrderRequest orderRequest) {
    log.info("Order={}", orderRequest);

    return pokemonOrderService.createOrder(orderRequest);
  }
}

