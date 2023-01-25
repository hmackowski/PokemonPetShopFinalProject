package com.promineotech.pokemon.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.pokemon.dao.IPokemonDao;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;

@Service
public class PokemonService implements IPokemonService {

  @Autowired
  private IPokemonDao pokemonDao;
  
  @Override
  public List<Pokemon> fetchPokemon(Integer pokemonId) {
    List<Pokemon> pokemon = pokemonDao.fetchPokemon(pokemonId);
    return pokemon;
  }

  @Override
  public List<Nature> fetchAllNatures() {
    List<Nature> natures = pokemonDao.fetchAllNatures();
    return natures;
  }

  @Override
  public List<Pokemon> fetchAllPokemon() {
   List<Pokemon> pokemon = pokemonDao.fetchAllPokemon();
    return pokemon;
  }

  @Override
  public Optional<Pokemon> addPokemon(int pokedexNumber, String name, String type1, String type2,
      int evolutionPhase) {
    return pokemonDao.addPokemon(pokedexNumber, name, type1, type2, evolutionPhase);

  }

  @Override
  public Optional<Pokemon> updatePokemon(Long pokemonId, int pokedexNumber, String name,
      String type1, String type2, int evolutionPhase) {
    
    return pokemonDao.updatePokemon(pokemonId, pokedexNumber, name, type1, type2, evolutionPhase);
  }

  @Override
  public Optional<Pokemon> deletePokemon(Long pokemonId) {
    return pokemonDao.deletePokemon(pokemonId);
  }

}
