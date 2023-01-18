package com.promineotech.pokemon.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.entity.Pokemon;
import com.promineotech.pokemon.entity.Trainers;

public class PokemonOrderDao implements IPokemonOrderDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Optional<Trainers> fetchTrainer(int trainerId) {
    // @formatter:off
    String sql = "" 
        + "SELECT * " 
        + "FROM trainers "
        + "WHERE trainer_id = :trainer_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("trainer_id", trainerId);

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
  }

  @Override
  public Optional<Pokemon> fetchPokemon(int pokemonId) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }

  @Override
  public Optional<Nature> fetchColor(Nature pokemonNature) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }

  @Override
  public Optional<Pokemon> fetchAllPokemon(List<Pokemon> pokemonList) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }

  @Override
  public Orders saveOrder(Long trainerId, int natureId, BigDecimal price) {
    // TODO Auto-generated method stub
    return null;
  }

  class CustomerResultSetExtractor implements ResultSetExtractor<Trainers> {
    @Override
    public Trainers extractData(ResultSet rs) throws SQLException {
      rs.next();

      // @formatter:off
      return Trainers.builder()
          .trainerId(rs.getLong("trainer_id"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .build();
      // @formatter:on

    }
  }
}
