package com.promineotech.pokemon.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/pokemon")
@OpenAPIDefinition(info = @Info(title = "Pokemon Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local Server.")})
public interface IPokemonController {



    // @formatter:off
    @Operation(
        summary = "Resturns a list of Pokemon",
        description = "Returns a list of Pokemon given a Pokemon ID Number",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of Pokemon are returned", 
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Pokemon.class))),
            @ApiResponse(
                responseCode = "400",
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No pokemon were found with the input criterial", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occured.", 
                content = @Content(mediaType = "application/json"))
        }     
     )
    
    
    @GetMapping("/natures")
   @ResponseStatus(code = HttpStatus.OK)
    List<Nature> fetchAllNatures();

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
    List<Pokemon> fetchPokemon(@RequestParam(required = false) Integer pokemonId);
  
  @GetMapping("/all")
  @ResponseStatus(code = HttpStatus.OK)
    List<Pokemon> fetchAllPokemon();
  
  @PostMapping("/addPokemon")
  @ResponseStatus(code = HttpStatus.CREATED)
    Optional<Pokemon> addPokemon(
        @RequestParam(required = true) int pokedexNumber,
        @RequestParam(required = true) String name, 
        @RequestParam(required = true) String type1, 
        @RequestParam(required = false) String type2, 
        @RequestParam(required = true) int evolutionPhase
        );
  
  @PutMapping("/updatePokemon")
  @ResponseStatus(code = HttpStatus.OK)
    Optional<Pokemon> updatePokemon(
        @RequestParam(required = true) Long pokemonId,
        @RequestParam(required = true) int pokedexNumber,
        @RequestParam(required = true) String name, 
        @RequestParam(required = true) String type1, 
        @RequestParam(required = false) String type2, 
        @RequestParam(required = true) int evolutionPhase
        );
  
  @DeleteMapping("/deletePokemon")
  @ResponseStatus(code = HttpStatus.OK)
    Optional<Pokemon> deletePokemon(@RequestParam(required = true) Long pokemonId);
  
  
  }




