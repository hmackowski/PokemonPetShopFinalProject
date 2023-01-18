package com.promineotech.pokemon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PokemonSalesDao implements IPokemonSalesDao {

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
            // formatter:off
                    
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
        
        return Nature.builder()
            .natureId(rs.getLong("nature_id"))
            .natureName(rs.getString("nature_name"))
            .build();
      }
    });
    
    

  }

}
