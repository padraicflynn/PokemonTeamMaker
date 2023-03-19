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

import pokemon.entity.User_made_teams_entity;

@Validated
@RequestMapping("/teams")
@OpenAPIDefinition(info = @Info(title = "User made teams info"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UserMadeTeamsController {

	// formatter: off
	// API responses for the reading of user made teams
	
	@Operation (
			summary = "Search the database for a user made team by their ID",
			description = "Returns the user made team with their name, what Pokemon are in the team, and any description provided by the user",
			responses = {
					@ApiResponse
					(responseCode = "200", 
					description = "A user made team is returned.", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = User_made_teams_entity.class))),
					
					@ApiResponse(responseCode = "400", description = "The request parameter is invalid.", content 
					= @Content(mediaType = "application/json")), 
					
					@ApiResponse(responseCode = "404", description = "No Teams were found with the input criteria.", 
					content = @Content(mediaType = "application/json")),
					
					@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = 
					@Content(mediaType = "application/json")) 
			},
			
			parameters = {
					@Parameter(name = "team_name_pk", allowEmptyValue = false, required = false,
							description = "The team from the user made teams table")
					
			}
			 )
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<User_made_teams_entity> fetchUserMadeTeamsById(
			@RequestParam(required = false)
			int team_name_pk);
	
// end package 
}
