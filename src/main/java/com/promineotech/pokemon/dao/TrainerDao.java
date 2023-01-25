package com.promineotech.pokemon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.pokemon.entity.Trainers;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TrainerDao implements ITrainerDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Trainers> fetchAllTrainers() {

    log.debug("in the dao");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM trainers";
    // formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<Trainers>() {
      public Trainers mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        // @formatter:off
        return Trainers.builder()
            .trainerId(rs.getLong("trainer_id"))
            .firstName(rs.getString("first_name"))
            .lastName(rs.getString("last_name"))
            .homeTown(rs.getString("home_town"))
            .build();
        // @formatter:on
      }
    });
  }

  @Override
  public Optional<Trainers> addnewTrainer(String firstName, String lastName, String hometown) {
    String sql = ""
        + "INSERT INTO trainers (first_name, last_name, home_town) "
        + "VALUES (:first_name, :last_name, :home_town)";
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    params.put("home_town", hometown);
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Trainers
        .builder()
        .firstName(firstName)
        .lastName(lastName)
        .homeTown(hometown)
        .build()
        );
  }

  @Override
  public Optional<Trainers> deleteTrainer(Long trainerId) {
    String sql = ""
        + "DELETE FROM trainers "
        + "WHERE trainer_id = :trainer_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("trainer_id", trainerId);
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Trainers
        .builder()
        .trainerId(trainerId)
        .build());
  }

}
