package pokemon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
 

@Validated
@RequestMapping("/pokemonInTeams")
@OpenAPIDefinition(info = @Info(title = "The used pokemon in teams"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface PokemonInTeamsController {

	// formatter: off
		// API responses for the reading what Pokemon are in which team
		
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
		
	// end package 
}
