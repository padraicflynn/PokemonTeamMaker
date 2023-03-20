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
 
import pokemon.entity.TrainerTableEntity;
import pokemon.service.DefaultPokemonTrainerService;


//import pokemon.service.DefaultPokemonTrainerService.NewTeamTrainer;

@Validated
@RequestMapping("/trainer")
@OpenAPIDefinition(info = @Info(title = "Pokemon trainer info"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface PokemonTrainerController {

	// formatter: off
	
	// This is an attempt to make a way to make a new trainer.
	/*
	
	public class NewTrainerMaker {
	 public NewTeamTrainer createTeam(NewTeamTrainer newTeamTrainer) {
		 if(newTeamTrainer.getNewTrainer().getOperation() == TrainerOperation.CREATE) {
			 DefaultPokemonTrainerService.createnewTrainer(newTeamTrainer.getNewTrainer());
		 }
		DefaultPokemonTrainerService.createTeam(teamTrainer);
	 }
	}
	
	*/
	
	
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
		  
		  @GetMapping("/trainer")
		//  @ApiResponse
		  @ResponseStatus(code = HttpStatus.OK)
		 List<TrainerTableEntity> fetchTrainerEntryById(
		      @RequestParam(required = false)
		      int trainer_id_pk);
	
// end package
}
