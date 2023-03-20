package pokemon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

import pokemon.entity.UserMadeTeamsEntity;

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
							schema = @Schema(implementation = UserMadeTeamsEntity.class))),
					
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
	List<UserMadeTeamsEntity> fetchUserMadeTeamsById(
			@RequestParam(required = false)
			int team_name_pk);

//!!! end read team
//!!! create team
	
	@Operation (
			summary = "Create a new team",
			description = "Create a team, you must already have a trainer PK to use for the trainer FK",
			responses = {
					@ApiResponse
					(responseCode = "200", 
					description = "A new team is created", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = UserMadeTeamsEntity.class))),
					
					@ApiResponse(responseCode = "400", description = "The request parameter is invalid.", content 
					= @Content(mediaType = "application/json")), 
					
					@ApiResponse(responseCode = "404", description = "No Teams were found with the input criteria.", 
					content = @Content(mediaType = "application/json")),
					
					@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = 
					@Content(mediaType = "application/json")) 
			},
			
			parameters = {
					@Parameter(name = "team_name", allowEmptyValue = false, required = false,
							description = "The new team name!"),
					
		
					@Parameter(name = "trainer_id_fk", allowEmptyValue = false, required = false,
							description = "The team's trainer's ID, Gary is 1, Lance is 2, then are user made incremented."),
					
				
					@Parameter(name = "description", allowEmptyValue = false, required = false,
							description = "A description of the team, maybe the theme or type of team.")
					
			}
			 )
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	UserMadeTeamsEntity createTeam(
			@RequestParam(required = false) String team_name,
			@RequestParam(required = false) int trainer_id_fk,
		    @RequestParam(required = false) String description);
//!!!end create team.
	
//!!!delete a team
	
	@Operation (
			summary = "Delete a team!",
			description = "Delete a team using the team's ID!",
			responses = {
					@ApiResponse
					(responseCode = "200", 
					description = "A team was deleted.", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = UserMadeTeamsEntity.class))),
					
					@ApiResponse(responseCode = "400", description = "The request parameter is invalid.", content 
					= @Content(mediaType = "application/json")), 
					
					@ApiResponse(responseCode = "404", description = "No Teams were found with the input criteria.", 
					content = @Content(mediaType = "application/json")),
					
					@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = 
					@Content(mediaType = "application/json")) 
			},
			
			parameters = {
					@Parameter(name = "team_name_pk", allowEmptyValue = false, required = false,
							description = "The team's ID you want to delete. team name!")
			}
			 )
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	UserMadeTeamsEntity deleteTeam(int team_name_pk);
	
//!!!end delete a team
	
//!!!update a team
	@Operation (
			summary = "Update an existing team.",
			description = "Update an existing team, please use and have the existing team ID ready please!",
			responses = {
					@ApiResponse
					(responseCode = "200", 
					description = "A team has been updated!", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = UserMadeTeamsEntity.class))),
					
					@ApiResponse(responseCode = "400", description = "The request parameter is invalid.", content 
					= @Content(mediaType = "application/json")), 
					
					@ApiResponse(responseCode = "404", description = "No Teams were found with the input criteria.", 
					content = @Content(mediaType = "application/json")),
					
					@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = 
					@Content(mediaType = "application/json")) 
			},
			
			parameters = {
					@Parameter(name = "team_name_pk", allowEmptyValue = false, required = false,
							description = "Use the same/existing team ID please!"),
					
					@Parameter(name = "team_name", allowEmptyValue = false, required = false,
							description = "Update the team name!"),
					
		
					@Parameter(name = "trainer_id_fk", allowEmptyValue = false, required = false,
							description = "Assign a trainer to the team!"),
					
				
					@Parameter(name = "description", allowEmptyValue = false, required = false,
							description = "Update the description of the team!")
					
			}
			 )
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	UserMadeTeamsEntity updateTeam(
			
			@RequestParam(required = false) String team_name,
			@RequestParam(required = false) int trainer_id_fk,
		    @RequestParam(required = false) String description,
	        @RequestParam(required = true) int team_name_pk);
//!!!end update a team


	
	
	
// end package 
}

	 
