package com.promineotech.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.promineotech.pokemon.dao.PokemonOrderDao;
import com.promineotech.pokemon.entity.OrderRequest;
import com.promineotech.pokemon.entity.Orders;

public interface IPokemonOrderService {

  Orders createOrder(OrderRequest orderRequest);

}
