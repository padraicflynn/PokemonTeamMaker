package pokemon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import pokemon.entity.PokemonInTeamsEntity;
import pokemon.entity.UserMadeTeamsEntity;
 

@Validated
@RequestMapping("/pokemonInTeams")
@OpenAPIDefinition(info = @Info(title = "The used pokemon in teams"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface PokemonInTeamsController {

	// formatter: off
		// API responses for Pokémon in teams table. What Pokémon are in a team, and the team's trainer ID.
		
		@Operation (
				summary = "See what Pokemon are used, and what the teams are made of and who their trainers are!",
				description = "See what Pokemon are in which teams, and who the team's trainer is!",
				responses = {
						@ApiResponse
						(responseCode = "200", 
						description = "A team and trainer are returned.", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = PokemonInTeamsEntity.class))),
						
						@ApiResponse(responseCode = "400", description = "The request parameter is invalid.", content 
						= @Content(mediaType = "application/json")), 
						
						@ApiResponse(responseCode = "404", description = "No Teams were found with the input criteria.", 
						content = @Content(mediaType = "application/json")),
						
						@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = 
						@Content(mediaType = "application/json")) 
				},
				
				parameters = {
						@Parameter(name = "team_name_fk", allowEmptyValue = false, required = false,
								description = "Enter the team ID")
						
				}
				 )
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		List<PokemonInTeamsEntity> fetchPokemonInTeamsById( 
				@RequestParam(required = false)
				int team_name_pk);
		

		// update a team, how we add Pokémon to a team one at a time. Stretch goal: add more than one at a time. 
		@Operation (
				summary = "Add Pokemon to an existing team.",
				description = "Add pokemon to a team that you already made! Honor system for this version, no more than six!",
				responses = {
						@ApiResponse
						(responseCode = "200", 
						description = "Pokemon have been added to the team!", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = PokemonInTeamsEntity.class))),
						
						@ApiResponse(responseCode = "400", description = "The request parameter is invalid.", content 
						= @Content(mediaType = "application/json")), 
						
						@ApiResponse(responseCode = "404", description = "No Teams were found with the input criteria.", 
						content = @Content(mediaType = "application/json")),
						
						@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = 
						@Content(mediaType = "application/json")) 
				},
				
				parameters = {
						@Parameter(name = "team_name_fk", allowEmptyValue = false, required = false,
								description = "Use the same/existing team ID please!"),
						
						@Parameter(name = "pokemon_pk_fk", allowEmptyValue = false, required = false,
								description = "Add the Pokemon's ID number! You can look that up in the Pokedex section!"),
				}
				 )
		
		@PutMapping
		@ResponseStatus(code = HttpStatus.OK)
		PokemonInTeamsEntity addPokemonToTeam(
				
				@RequestParam(required = false) int team_name_fk,
		        @RequestParam(required = true) int pokemon_pk_fk);
 
	// end package 
}
