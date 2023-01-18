package com.promineotech.pokemon.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.pokemon.dao.IPokemonSalesDao;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PokemonSalesService implements IPokemonSalesService {

  @Autowired
  private IPokemonSalesDao pokemonSalesDao;
  
  @Override
  public List<Pokemon> fetchPokemon(Integer pokemonId) {
    log.info("attempted");
    List<Pokemon> pokemon = pokemonSalesDao.fetchPokemon(pokemonId);
    log.info("pokemonSalesDao.fetchPokemon was called");
    return pokemon;
  }

  @Override
  public List<Nature> fetchAllNatures() {
    List<Nature> natures = pokemonSalesDao.fetchAllNatures();
    return natures;
  }

}
