package com.promineotech.pokemon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Orders;
import com.promineotech.pokemon.entity.Pokemon;
import com.promineotech.pokemon.entity.PokemonOrder;
import com.promineotech.pokemon.entity.Trainers;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PokemonOrderDao implements IPokemonOrderDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;  
  
//@Autowired
 // PokemonOrder po;
  
 //@Autowired
  private Orders orders;
  
  //@Autowired
  private Pokemon pokemon; 

  @Override
  public Optional<Trainers> fetchTrainer(String trainer) {
    // @formatter:off
    String sql = "" 
        + "SELECT * " 
        + "FROM trainers "
        + "WHERE trainer_id = :trainer_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("trainer_id", trainer);
    log.debug("Returning trainer");
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new TrainerResultSetExtractor()));
  }


  @Override
  public Optional<Pokemon> fetchPokemon(String pokemon) {
    // @formatter:off
    String sql = "" 
        + "SELECT * " 
        + "FROM pokemon "
        + "WHERE pokemon_id = :pokemon_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("pokemon_id", pokemon);
    log.debug("Returning pokemon");
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new PokemonResultSetExtractor()));
  }


  @Override
  public Optional<Nature> fetchNature(String nature) {
    // @formatter:off
    String sql = "" 
        + "SELECT * " 
        + "FROM nature "
        + "WHERE nature_id = :nature_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("nature_id", nature);
    log.debug("Returning pokemon");
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new NatureResultSetExtractor()));
  }


  @Override
  public Orders saveOrder(Trainers trainer,Pokemon pokemon, Nature natures, double price) {
    SqlParams params = generateInsertSql(trainer, natures, price);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long orderId = keyHolder.getKey().longValue();
    
    savePokemon(pokemon, orderId);
    // @formatter:off
    return Orders.builder()
        .orderId(orderId)
        .trainerId(trainer)
        .natureId(natures)
        .price(price)
        .build();
    // @formatter:on
  }
  
  



  private void savePokemon(Pokemon pokemon, Long orderId) {
    SqlParams params = generateInsertSql(pokemon, orderId);
    jdbcTemplate.update(params.sql, params.source);
    
  }





  private SqlParams generateInsertSql(Pokemon pokemon, Long orderId) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO pokemon_orders ("
        + "order_id, pokemon_id"
        + ") VALUES ("
        + ":order_id, :pokemon_id"
        + ")";
    // @formatter:on
    
    params.source.addValue("pokemon_id", pokemon.getPokemonId());
    params.source.addValue("order_id", orderId);
    
    return params;
  }





  class TrainerResultSetExtractor implements ResultSetExtractor<Trainers> {

    @Override
    public Trainers extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();

      // @formatter:off
      return Trainers.builder()
          .trainerId(rs.getLong("trainer_id"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .homeTown(rs.getString("home_town"))
          .build();
      
      // @formatter:on
    }

  }
  
  class PokemonResultSetExtractor implements ResultSetExtractor<Pokemon> {

    @Override
    public Pokemon extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();

      // @formatter:off
      return Pokemon.builder()
          .pokemonId(rs.getLong("pokemon_id"))
          .name(rs.getString("name"))
          .type1(rs.getString("type1"))
          .type1(rs.getString("type2"))
          .evolutionPhase(rs.getInt("evolution_phase"))
          .build();
      
      // @formatter:on
    }

  }


  class NatureResultSetExtractor implements ResultSetExtractor<Nature> {

    @Override
    public Nature extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();

      // @formatter:off
      return Nature.builder()
          .natureId(rs.getLong("nature_id"))
          .natureName(rs.getString("nature_name"))
          .build();
      
      // @formatter:on
    }

  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
  private SqlParams generateInsertSql(Trainers trainer, Nature nature, double price) {
    // @formatter:off
    String sql = ""
        + "INSERT INTO orders ("
        + "trainer_id, nature_id, price"
        + ") VALUES ("
        + ":trainer_id, :nature_id, :price"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("trainer_id",  trainer.getTrainerId());
    //params.source.addValue("pokemon_id",  pokemon.getPokemonId());
    params.source.addValue("nature_id",  nature.getNatureId());
    params.source.addValue("price",  price);
    
    return params;
  }


  public int fetchEvolutionPhase(@NotNull String string) {
    
    // @formatter:off
    String sql = ""
        + "SELECT evolution_phase "
        + "FROM pokemon "
        + "WHERE pokemon_id = :pokemon_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    
    params.put("pokemon_id", string );
    log.debug("Returning trainer");
    Integer evoPhase = jdbcTemplate.queryForObject(sql, params, Integer.class);
    return evoPhase + 1;
  }
  
  
  class EvolutionPhaseResultSetExtractor implements ResultSetExtractor<Pokemon> {

    @Override
    public Pokemon extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();

      // @formatter:off
      return Pokemon.builder()
          .evolutionPhase(rs.getInt("evolution_phase"))
          .build();
      
      // @formatter:on
    }

  }

  public List<PokemonOrder> pullOrder(String pokemonOrderId) {
    String sql = ""
        + "SELECT o.order_id, t.first_name, t.last_name, p.name, n.nature_name, o.price, o.order_time "
        + "FROM pokemon as p "
        + "INNER JOIN pokemon_orders as po "
        + "     ON p.pokemon_id  = po.pokemon_id "
        + "INNER JOIN orders as o "
        + "     ON po.order_id  = o.order_id "
        + "INNER JOIN trainers AS t "
        + "     ON o.trainer_id = t.trainer_id "
        + "INNER JOIN nature n "
        + "     ON o.nature_id = n.nature_id "
        + "WHERE o.order_id = :order_id";
    
        
    Map<String, Object> params = new HashMap<>();
    params.put("order_id", pokemonOrderId);
    return jdbcTemplate.query(sql, params, new RowMapper<PokemonOrder>() {

      @Override
      public PokemonOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        return PokemonOrder
            .builder()
            .pokemonOrderId(Long.parseLong(pokemonOrderId))
            .orders(orders)
            //.pokemonOrderId(pokemon)
            .build();
      }});


  }

}
