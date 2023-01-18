package com.promineotech.pokemon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.pokemon.entity.OrderRequest;
import com.promineotech.pokemon.entity.Orders;

@Validated
@RequestMapping("/orders")
public interface IPokemonOrderController {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Orders createOrder(@RequestBody OrderRequest orderRequest);
}
