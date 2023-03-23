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
	  
	 
// GET Pokemon by using ALL THREE VALUES, the other methods only need one value to search, 
// this is more for testing/seeing the code work.
	 
	  @Override
	public List<PokedexEntryEntity> fetchPokedexEntry(int pokemon_pk, String pokemon_name, PokemonTypeEnum pokemon_type) {
		
 
		return pokedexEntryService.fetchPokedexEntry(pokemon_pk, pokemon_name, pokemon_type);
	}

// Here we can search our Pokedéx Entry table, the main database
// by looking up Pokémon by their ID entry.
// Their ID auto increments, and I put them in order so
// they will line up with the official Pokédx.
	
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByID(int pokemon_pk) {
		 
			return pokedexEntryService.fetchPokedexEntryByID(pokemon_pk);
		}
	
// Here we can search by the typing of the Pokémon. The types are all in an enum.
	
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByType(PokemonTypeEnum pokemon_type) {
		 
			return pokedexEntryService.fetchPokedexEntryByType(pokemon_type);
		}

//Here we can search the database by the name of the pokemon, 
// maybe as a stretch goal I can use the LIKE operator in a
// sql statement so you can search by partial name, making it easier
// if you don't know the right spelling but are close enough. 
	
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByName(String pokemon_name) {
		 
			return pokedexEntryService.fetchPokedexEntryByName(pokemon_name);
		}
	//end of package
	}
	
	

