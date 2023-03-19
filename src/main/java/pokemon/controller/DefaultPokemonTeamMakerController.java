package pokemon.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pokemon.entity.Pokedex_entry_entity;
import pokemon.entity.Pokemon_type_enum;
import pokemon.service.PokemonService;

 
	
	 


	@RestController
	@Slf4j 
public class DefaultPokemonTeamMakerController implements PokemonTeamMakerControllerInterface{
		
	 @Autowired
	 private PokemonService pokemonService;
	  
	 
// GET Pokemon by ALL THREE VALUES (not easy for a user to do, not practical in real world app but will use for this project)
	 
	  @Override
	public List<Pokedex_entry_entity> fetchPokedexEntry(int pokemon_pk, String pokemon_name, Pokemon_type_enum pokemon_type) {
		
 
		return pokemonService.fetchPokedexEntry(pokemon_pk, pokemon_name, pokemon_type);
	}
	
//!!!!!End search by Entry!!!!
//!!!! Read By ID!!!!!
// POKEMON BY Pokedex ID (Primary key)
	
	@Override
	public List<Pokedex_entry_entity> fetchPokedexEntryByID(int pokemon_pk) {
		 
			return pokemonService.fetchPokedexEntryByID(pokemon_pk);
		}
	
//!!!!End search by ID!!!!
// POKEMON BY TYPE (type is a little muddled: stretch goal is to clean up enum and be able to search for two type pokemon by either/or type)
	
	@Override
	public List<Pokedex_entry_entity> fetchPokedexEntryByType(Pokemon_type_enum pokemon_type) {
		 
			return pokemonService.fetchPokedexEntryByType(pokemon_type);
		}

//!!!End search by TYPE!!!!
//!!!POKEMON BY NAME!!!
	
	@Override
	public List<Pokedex_entry_entity> fetchPokedexEntryByName(String pokemon_name) {
		 
			return pokemonService.fetchPokedexEntryByName(pokemon_name);
		}
	
	
	
	//end of package
	}
	
	

