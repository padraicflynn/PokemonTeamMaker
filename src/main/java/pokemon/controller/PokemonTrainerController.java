package pokemon.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
 
import pokemon.entity.TrainerTableEntity;
import pokemon.entity.UserMadeTeamsEntity;
import pokemon.service.DefaultPokemonTrainerService;


//import pokemon.service.DefaultPokemonTrainerService.NewTeamTrainer;

@Validated
@RequestMapping("/trainer")
@OpenAPIDefinition(info = @Info(title = "Pokemon trainer info"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface PokemonTrainerController {

	//API responses for reading the trainers table
	@Operation (
		      summary = "Searches the Database of trainers by ID, "
		      		+ "the first two are Gary and Lance and then any user made trainers",
		      description = "Returns the trainer of the selected ID",
		      responses = {
		          @ApiResponse
		          	(responseCode = "200",
		          	description = "A trainer name is returned.",
		          	content = @Content(
		          			mediaType = "application/json",
		          			schema = @Schema(implementation = TrainerTableEntity.class))),
		          
		          @ApiResponse(responseCode = "400", description = "The request parameter are invalid.", content
		          = @Content(mediaType = "application/json")),
		          
		          @ApiResponse(responseCode = "404", description = "No Trainers were found with the input criteria.", content
		          = @Content(mediaType = "application/json")),
		          
		          @ApiResponse(responseCode = "500", description = "An unplanned error occured.", content
		          = @Content(mediaType = "application/json"))
		      },
		      
		     
		      parameters = {
		    	  @Parameter(name = "trainer_id_pk", allowEmptyValue = false, required = false, 
		    			  description = "The trainer from the trainer table"
		    			  		+ " (remeber two are premade, after that are user made)")
		       		          		 
		      }
		      )
		  
		  @GetMapping
		//  @ApiResponse
		  @ResponseStatus(code = HttpStatus.OK)
		 List<TrainerTableEntity> fetchTrainerEntryById(
		      @RequestParam(required = false)
		      int trainer_id_pk);
	
	//!!! create trainer
	
		@Operation (
				summary = "Create a new trainer. ",
				description = "Create a new trainer. A trainer can then have a team. ",
				responses = {
						@ApiResponse
						(responseCode = "200", 
						description = "A new trainer is created", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = TrainerTableEntity.class))),
						
						@ApiResponse(responseCode = "400", description = "The request parameter is invalid.", content 
						= @Content(mediaType = "application/json")), 
						
						@ApiResponse(responseCode = "404", description = "No Trainers were found with the input criteria.", 
						content = @Content(mediaType = "application/json")),
						
						@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = 
						@Content(mediaType = "application/json")) 
				},
				
				parameters = {
						
						@Parameter(name = "trainer_name", allowEmptyValue = false, required = false,
								description = "The new trainer's name!")
						
				}
				 )
		
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		TrainerTableEntity createTrainer(
				@RequestParam(required = false) String trainer_name);
			    
		
	//!!!end create trainer
		
		
		//!!!delete a trainer
		
		@Operation (
				summary = "Delete a trainer!",
				description = "Delete a traienr using the trainer's ID!",
				responses = {
						@ApiResponse
						(responseCode = "200", 
						description = "A trainer was deleted.", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = TrainerTableEntity.class))),
						
						@ApiResponse(responseCode = "400", description = "The request parameter is invalid.", content 
						= @Content(mediaType = "application/json")), 
						
						@ApiResponse(responseCode = "404", description = "No trainers were found with the input criteria.", 
						content = @Content(mediaType = "application/json")),
						
						@ApiResponse(responseCode = "500", description = "An unplanned error occured.", content = 
						@Content(mediaType = "application/json")) 
				},
				
				parameters = {
						@Parameter(name = "trainer_id_pk", allowEmptyValue = false, required = false,
								description = "The ID of the trainer you want to delete!")
				}
				 )
		
		@DeleteMapping
		@ResponseStatus(code = HttpStatus.OK)
		TrainerTableEntity deleteTrainer(int trainer_id_pk);
		
	//!!!end delete a team
// end package
}
