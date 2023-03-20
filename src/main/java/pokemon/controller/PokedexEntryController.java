package pokemon.controller;

 

import java.util.List;




// import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

 
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.PokemonTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.*;


@Validated
@RequestMapping("/pokemon")
@OpenAPIDefinition(info = @Info(title = "Pokemon team maker"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})


public interface PokedexEntryController {
	  
	 // formatter: off

	// API responses for reading the list of available Pokemon
	
	@Operation (
	      summary = "Search for Pokemon by entering the ID, Name, and Type,"
	      		+ " up to 151, just to see it in the database!",
	      description = "Returns the Pokemon to see it in the database",
	      responses = {
	          @ApiResponse
	          	(responseCode = "200",
	          	description = "A list of Pokemon is returned.",
	          	content = @Content(
	          			mediaType = "application/json",
	          			schema = @Schema(implementation = PokedexEntryEntity.class))),
	          
	          @ApiResponse(responseCode = "400", description = "The request parameter are invalid.", content
	          = @Content(mediaType = "application/json")),
	          
	          @ApiResponse(responseCode = "404", description = "No Pokemon were found with the input criteria.", content
	          = @Content(mediaType = "application/json")),
	          
	          @ApiResponse(responseCode = "500", description = "An unplanned error occured.", content
	          = @Content(mediaType = "application/json"))
	      },
	      
	      // !!!! allow empty value was changed from false to true to see if swagger likes that
	      parameters = {
	    	  @Parameter(name = "pokemon_pk", allowEmptyValue = false, required = false, 
	    			  description = "The Pokemon's numerical placement in the Pokedex"),
	          @Parameter(name = "pokemon_name", allowEmptyValue = false, required = false, 
	          		  description = "The name of the Pokemon"),
	          @Parameter(name = "pokemon_type", allowEmptyValue = false, required = false, 
	          		  description = "The typing of the Pokemon, i.e., 'Flying'")
	    	 
	      }
	      )
	  
	  @GetMapping
	  @ResponseStatus(code = HttpStatus.OK)
	 List<PokedexEntryEntity> fetchPokedexEntry(
	      @RequestParam(required = false)
	      int pokemon_pk,
	      @RequestParam(required = false)
	      String pokemon_name,
	      @RequestParam(required = false)
          PokemonTypeEnum pokemon_type);
	 	 
	// NEXT OPERATION: SEARCH BY ID		 
		
		@Operation (
		      summary = "Searches the Database (Pokedex) by the ID, 1-151,"
		      		+ " in the offical Pokedex and returns the name and type",
		      description = "Returns the Pokemon with the selected ID",
		      responses = {
		          @ApiResponse
		          	(responseCode = "200",
		          	description = "A Pokemon is returned.",
		          	content = @Content(
		          			mediaType = "application/json",
		          			schema = @Schema(implementation = PokedexEntryEntity.class))),
		          
		          @ApiResponse(responseCode = "400", description = "The request parameter are invalid.", content
		          = @Content(mediaType = "application/json")),
		          
		          @ApiResponse(responseCode = "404", description = "No Pokemon were found with the input criteria.", content
		          = @Content(mediaType = "application/json")),
		          
		          @ApiResponse(responseCode = "500", description = "An unplanned error occured.", content
		          = @Content(mediaType = "application/json"))
		      },
		      
		      // !!!! allow empty value was changed from false to true to see if swagger likes that
		      parameters = {
		    	  @Parameter(name = "pokemon_pk", allowEmptyValue = true, required = false, 
		    			  description = "The Pokemon's numerical placement in the Pokedex")
		       		          		 
		      }
		      )
		  
		  @GetMapping("/ID")
		//  @ApiResponse
		  @ResponseStatus(code = HttpStatus.OK)
		 List<PokedexEntryEntity> fetchPokedexEntryByID(
		      @RequestParam(required = false)
		      int pokemon_pk);

// !!! END SEARCH BY ID
// NEXT OPERATION: SEARCH BY NAME		 
			
			@Operation (
			      summary = "Searches the Pokedex by Name (up to 151) "
			      		+ "in the offical Pokedex and returns the name and type",
			      description = "Returns the Pokemon with the selected ID",
			      responses = {
			          @ApiResponse
			          	(responseCode = "200",
			          	description = "A Pokemon is returned.",
			          	content = @Content(
			          			mediaType = "application/json",
			          			schema = @Schema(implementation = PokedexEntryEntity.class))),
			          
			          @ApiResponse(responseCode = "400", description = "The request parameter are invalid.", content
			          = @Content(mediaType = "application/json")),
			          
			          @ApiResponse(responseCode = "404", description = "No Pokemon were found with the input criteria.", content
			          = @Content(mediaType = "application/json")),
			          
			          @ApiResponse(responseCode = "500", description = "An unplanned error occured.", content
			          = @Content(mediaType = "application/json"))
			      },
			      
			      // !!!! allow empty value was changed from false to true to see if swagger likes that
			      parameters = {
			    	  @Parameter(name = "pokemon_name", allowEmptyValue = true, required = false, 
			    			  description = "The Pokemon by name!")
			       		          		 
			      }
			      )
			  
			  @GetMapping("/Name")
			//  @ApiResponse
			  @ResponseStatus(code = HttpStatus.OK)
			 List<PokedexEntryEntity> fetchPokedexEntryByName(
			      @RequestParam(required = false)
			      String pokemon_name);

// !!! END SEARCH BY Name
// NEXT OPERATION: SEARCH BY Type		 
				
				@Operation (
				      summary = "Searches the Pokedex by the type or types and returns Pokemon by"
				      		+ " that type or types. Fun fact: In the orginal 151 there are no plain flying, "
				      		+ "ice, or ghost types, they are all dual types,"
				      		+ " like flying/normal, water/ice or ghost/poision etc! "
				      		+ "Also note that steel and fairy types are here to make this compatiable with future updates!",
				      description = "Returns the Pokemon with the selected typing",
				      responses = {
				          @ApiResponse
				          	(responseCode = "200",
				          	description = "A Pokemon of the type is returned.",
				          	content = @Content(
				          			mediaType = "application/json",
				          			schema = @Schema(implementation = PokedexEntryEntity.class))),
				          
				          @ApiResponse(responseCode = "400", description = "The request parameter are invalid.", content
				          = @Content(mediaType = "application/json")),
				          
				          @ApiResponse(responseCode = "404", description = "No Pokemon were found with the input criteria.", content
				          = @Content(mediaType = "application/json")),
				          
				          @ApiResponse(responseCode = "500", description = "An unplanned error occured.", content
				          = @Content(mediaType = "application/json"))
				      },
				      
				      // !!!! allow empty value was changed from false to true to see if swagger likes that
				      parameters = {
				    	  @Parameter(name = "pokemon_type", allowEmptyValue = true, required = false, 
				    			  description = "The Pokemon's type or types")
				       		          		 
				      }
				      )
				  
				  @GetMapping("/Type")
				//  @ApiResponse
				  @ResponseStatus(code = HttpStatus.OK)
				 List<PokedexEntryEntity> fetchPokedexEntryByType(
				      @RequestParam(required = false)
				      PokemonTypeEnum pokemon_type);

// !!! END SEARCH BY Type
	 
		 
	 
		      
		
		
		
		// formatter: on
	 
	// package end
}
