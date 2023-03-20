package pokemon.service;

import java.util.Collections;




import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.dao.DefaultPokedexEntryDao;
import pokemon.dao.PokedexEntryDao;
import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.PokemonTypeEnum;


@Slf4j
@Service
public class DefaultPokedexEntryService implements PokedexEntryService {

	@Autowired
	private DefaultPokedexEntryDao pokemonTeamDao;
	

	
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntry(
			int pokemon_pk, String pokemon_name, PokemonTypeEnum pokemon_type) {
		log.info("!!!Look, we found this entry " + pokemon_name);
		 
		List<PokedexEntryEntity> pokemonEntry = 
				pokemonTeamDao.fetchPokedexEntry(pokemon_pk, pokemon_name, pokemon_type);
		
		if(pokemonEntry.isEmpty()) {
			String msg = String.format("No Pokemon matches were found");
		
		
		throw new NoSuchElementException(msg);
		}
		
	//	Collections.sort(pokemonEntry);
		
		return pokemonEntry;
	}



	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByID(int pokemon_pk) {
		
			log.info("!!!Look, we found this pokedex ID: " + pokemon_pk);
			 
			List<PokedexEntryEntity> pokemonEntry = 
					pokemonTeamDao.fetchPokedexEntryByID(pokemon_pk);
			
			if(pokemonEntry.isEmpty()) {
				String msg = String.format("No Pokemon matches were found");
			
			
			throw new NoSuchElementException(msg);
			}
			
		//	Collections.sort(pokemonEntry);
			
			return pokemonEntry;
	}



	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByType(PokemonTypeEnum pokemon_type) {
		log.info("!!!Look, we found this typing " + pokemon_type);
		 
		List<PokedexEntryEntity> pokemonEntry = 
				pokemonTeamDao.fetchPokedexEntryByType(pokemon_type);
		
		if(pokemonEntry.isEmpty()) {
			String msg = String.format("No Pokemon matches were found");
		
		
		throw new NoSuchElementException(msg);
		}
		
	//	Collections.sort(pokemonEntry);
		
		return pokemonEntry;
	}



	@Override
	public List<PokedexEntryEntity> fetchPokedexEntryByName(String pokemon_name) {
		log.info("!!!Look, we found this (name) " + pokemon_name);
		 
		List<PokedexEntryEntity> pokemonEntry = 
				pokemonTeamDao.fetchPokedexEntryByName(pokemon_name);
		
		if(pokemonEntry.isEmpty()) {
			String msg = String.format("No Pokemon matches were found");
		
		
		throw new NoSuchElementException(msg);
		}
		
	//	Collections.sort(pokemonEntry);
		
		return pokemonEntry;
	}
}
