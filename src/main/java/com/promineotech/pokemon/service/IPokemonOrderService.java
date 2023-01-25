package com.promineotech.pokemon.service;

import java.util.List;
import com.promineotech.pokemon.entity.OrderRequest;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.entity.PokemonOrder;

public interface IPokemonOrderService {

  Orders createOrder(OrderRequest orderRequest);

  List<PokemonOrder> pullOrder(String pokemonOrderId);

}
