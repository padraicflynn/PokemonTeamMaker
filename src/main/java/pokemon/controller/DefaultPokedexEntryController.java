package pokemon.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.PokemonTypeEnum;
import pokemon.service.PokedexEntryService;

 
	
	 


	@RestController
	@Slf4j 
public class DefaultPokedexEntryController implements PokedexEntryController{
		
	 @Autowired
	 private PokedexEntryService pokedexEntryService;
	  
	 
// GET Pokemon by ALL THREE VALUES (not easy for a user to do, not practical in real world app but will use for this project)
	 
	  @Override
	public List<PokedexEntryEntity> fetchPokedexEntry(int pokemon_pk, String pokemon_name, PokemonTypeEnum pokemon_type) {
		
 
		return pokedexEntryService.fetchPokedexEntry(pokemon_pk, pokemon_name, pokemon_type);
	}
	
//!!!!!End search by Entry!!!!
//!!!! Read By ID!!!!!
// POKEMON BY Pokedex ID (Primary key)
	
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByID(int pokemon_pk) {
		 
			return pokedexEntryService.fetchPokedexEntryByID(pokemon_pk);
		}
	
//!!!!End search by ID!!!!
// POKEMON BY TYPE (type is a little muddled: stretch goal is to clean up enum and be able to search for two type pokemon by either/or type)
	
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByType(PokemonTypeEnum pokemon_type) {
		 
			return pokedexEntryService.fetchPokedexEntryByType(pokemon_type);
		}

//!!!End search by TYPE!!!!
//!!!POKEMON BY NAME!!!
	
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByName(String pokemon_name) {
		 
			return pokedexEntryService.fetchPokedexEntryByName(pokemon_name);
		}
	
	
	
	//end of package
	}
	
	

