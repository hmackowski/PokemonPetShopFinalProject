package com.promineotech.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class PokemonSales {

  
  public static void main(String[] args) {
    SpringApplication.run(PokemonSales.class, args);

  }

}
