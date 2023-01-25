package com.promineotech.pokemon.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.pokemon.entity.OrderRequest;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.entity.PokemonOrder;

@Validated
@RequestMapping("/orders")
public interface IPokemonOrderController {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Orders createOrder(@RequestBody OrderRequest orderRequest);
    
    @GetMapping("/pullOrder")
    @ResponseStatus(code = HttpStatus.OK)
    List<PokemonOrder> pullOrder(String pokemonOrderId);
}
