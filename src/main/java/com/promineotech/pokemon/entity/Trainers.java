package com.promineotech.pokemon.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Trainers {
  private Long trainerId;
  private String firstName;
  private String lastName;
  private String homeTown;
}
