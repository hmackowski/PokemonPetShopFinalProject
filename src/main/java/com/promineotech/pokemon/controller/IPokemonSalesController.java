package com.promineotech.pokemon.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.pokemon.entity.Nature;
import com.promineotech.pokemon.entity.Pokemon;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/pokemon")
@OpenAPIDefinition(info = @Info(title = "Pokemon Sales Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local Server.")})
public interface IPokemonSalesController {



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
        }//,
       // parameters = {
         //   @Parameter(
            //    name = "pokemonId", 
            //    allowEmptyValue = false, 
             //   required = false, 
             //   description = "The model name (i.e., '1')")
/*            @Parameter(
                name = "trim", 
                allowEmptyValue = false, 
                required = false, 
                description = "The trim level (i.e., 'Sport')")*/
       // }
        
     )
    @GetMapping("/natures")
   @ResponseStatus(code = HttpStatus.OK)
    List<Nature> fetchAllPokemon();

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
    List<Pokemon> fetchPokemon(@RequestParam(required = false) Integer pokemonId);
  }




