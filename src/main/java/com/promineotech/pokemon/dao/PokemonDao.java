package com.promineotech.pokemon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PokemonDao implements IPokemonDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Pokemon> fetchPokemon(Integer pokemonId) {
    log.info("DAO: PokemonID={}", pokemonId);

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM pokemon "
        + "WHERE pokemon_id = :pokemon_id";
    // formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("pokemon_id", pokemonId);
   
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

        @Override
        public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
                    
            return Pokemon.builder()
                    .pokemonId(rs.getLong("pokemon_id"))
                    .pokedexNumber(rs.getInt("pokedex_number"))
                    .name(rs.getString("name"))
                    .type1(rs.getString("type1"))
                    .type2(rs.getString("type2"))
                    .evolutionPhase(rs.getInt("evolution_phase"))
                    .build();
            // @formatter:on    
      }
    });
  }

  @Override
  public List<Nature> fetchAllNatures() {

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM nature";
    // formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<Nature>() {
      public Nature mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Nature.builder()
            .natureId(rs.getLong("nature_id"))
            .natureName(rs.getString("nature_name"))
            .build();
        // @formatter:on
      }
    });



  }

  @Override
  public List<Pokemon> fetchAllPokemon() {

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM pokemon";
    // formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<Pokemon>() {
      public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        // @formatter:off
        return Pokemon.builder()
            .pokemonId(rs.getLong("pokemon_id"))
            .pokedexNumber(rs.getInt("pokedex_number"))
            .name(rs.getString("name"))
            .type1(rs.getString("type1"))
            .type2(rs.getString("type2"))
            .evolutionPhase(rs.getInt("evolution_phase"))
            .build();
        // @formatter:on
      }
    });
  }

  @Override
  public Optional<Pokemon> addPokemon(int pokedexNumber, String name, String type1, String type2,
      int evolutionPhase) {
    String sql = "" + "INSERT INTO pokemon (pokedex_number, name, type1, type2, evolution_phase) "
        + "VALUES(:pokedex_number, :name, :type1, :type2, :evolution_phase)";

    Map<String, Object> params = new HashMap<>();
    params.put("pokedex_number", pokedexNumber);
    params.put("name", name);
    params.put("type1", type1);
    params.put("type2", type2);
    params.put("evolution_phase", evolutionPhase);

    jdbcTemplate.update(sql, params);

   // @formatter:off
   return Optional.ofNullable(Pokemon
       .builder()
       .pokedexNumber(pokedexNumber)
       .name(name)
       .type1(type1)
       .type2(type2)
       .evolutionPhase(evolutionPhase)
       .build());
    // @formatter:on
  }

  @Override
  public Optional<Pokemon> updatePokemon(Long pokemonId, int pokedexNumber, String name,
      String type1, String type2, int evolutionPhase) {

    // @formatter:off
    String sql = ""
        + "UPDATE pokemon "
        + "SET pokedex_number = :pokedex_number, name = :name, type1 = :type1, type2 = :type2, evolution_phase = :evolution_phase "
        + "WHERE pokemon_id = :pokemon_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("pokemon_id", pokemonId);
    params.put("pokedex_number", pokedexNumber);
    params.put("name", name);
    params.put("type1", type1);
    params.put("type2", type2);
    params.put("evolution_phase", evolutionPhase);

    jdbcTemplate.update(sql, params);

    // @formatter:off
    return Optional.ofNullable(Pokemon
        .builder()
        .pokemonId(pokemonId)
        .pokedexNumber(pokedexNumber)
        .name(name)
        .type1(type1)
        .type2(type2)
        .evolutionPhase(evolutionPhase)
        .build());
     // @formatter:on
  }


  // Deletes a pokemon from the 'pokemon' table given a pokemonId number
  @Override
  public Optional<Pokemon> deletePokemon(Long pokemonId) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM pokemon "
        + "WHERE pokemon_id = :pokemon_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("pokemon_id", pokemonId);

    jdbcTemplate.update(sql, params);
    System.out.println("Deleted pokemonID=" + pokemonId);

    // @formatter:off
    return Optional.ofNullable(Pokemon
        .builder()
        .pokemonId(pokemonId)
        .build());
    // @formatter:on
  }

}
