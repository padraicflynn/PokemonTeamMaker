package pokemon.service;

import java.util.Collections;




import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.dao.DefaultPokemonTeamDao;
import pokemon.dao.PokemonTeamDao;
import pokemon.entity.Pokedex_entry_entity;
import pokemon.entity.Pokemon_type_enum;


@Slf4j
@Service
public class DefaultPokemonService implements PokemonService {

	@Autowired
	private DefaultPokemonTeamDao pokemonTeamDao;
	

	
	@Override
	public List<Pokedex_entry_entity> fetchPokedexEntry(
			int pokemon_pk, String pokemon_name, Pokemon_type_enum pokemon_type) {
		log.info("!!!Look, we found this entry " + pokemon_name);
		 
		List<Pokedex_entry_entity> pokemonEntry = 
				pokemonTeamDao.fetchPokedexEntry(pokemon_pk, pokemon_name, pokemon_type);
		
		if(pokemonEntry.isEmpty()) {
			String msg = String.format("No Pokemon matches were found");
		
		
		throw new NoSuchElementException(msg);
		}
		
	//	Collections.sort(pokemonEntry);
		
		return pokemonEntry;
	}



	@Override
	public List<Pokedex_entry_entity> fetchPokedexEntryByID(int pokemon_pk) {
		
			log.info("!!!Look, we found this pokedex ID: " + pokemon_pk);
			 
			List<Pokedex_entry_entity> pokemonEntry = 
					pokemonTeamDao.fetchPokedexEntryByID(pokemon_pk);
			
			if(pokemonEntry.isEmpty()) {
				String msg = String.format("No Pokemon matches were found");
			
			
			throw new NoSuchElementException(msg);
			}
			
		//	Collections.sort(pokemonEntry);
			
			return pokemonEntry;
	}



	@Override
	public List<Pokedex_entry_entity> fetchPokedexEntryByType(Pokemon_type_enum pokemon_type) {
		log.info("!!!Look, we found this typing " + pokemon_type);
		 
		List<Pokedex_entry_entity> pokemonEntry = 
				pokemonTeamDao.fetchPokedexEntryByType(pokemon_type);
		
		if(pokemonEntry.isEmpty()) {
			String msg = String.format("No Pokemon matches were found");
		
		
		throw new NoSuchElementException(msg);
		}
		
	//	Collections.sort(pokemonEntry);
		
		return pokemonEntry;
	}



	@Override
	public List<Pokedex_entry_entity> fetchPokedexEntryByName(String pokemon_name) {
		log.info("!!!Look, we found this (name) " + pokemon_name);
		 
		List<Pokedex_entry_entity> pokemonEntry = 
				pokemonTeamDao.fetchPokedexEntryByName(pokemon_name);
		
		if(pokemonEntry.isEmpty()) {
			String msg = String.format("No Pokemon matches were found");
		
		
		throw new NoSuchElementException(msg);
		}
		
	//	Collections.sort(pokemonEntry);
		
		return pokemonEntry;
	}
}
