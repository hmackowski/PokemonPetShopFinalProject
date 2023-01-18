package com.promineotech.pokemon.service;

import com.promineotech.pokemon.entity.OrderRequest;
import com.promineotech.pokemon.entity.Orders;

public interface IPokemonOrderService {

  Orders createOrder(OrderRequest orderRequest);

}
