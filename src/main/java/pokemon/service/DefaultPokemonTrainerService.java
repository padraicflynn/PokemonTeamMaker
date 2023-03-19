package pokemon.service;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.dao.DefaultPokemonTrainerDao;
import pokemon.entity.Pokedex_entry_entity;
import pokemon.entity.Trainer_table_entity;

//SLf4j lets us use the log statements to see things in the console as we go!
@Slf4j
@Service
public class DefaultPokemonTrainerService implements PokemonTrainerService{

	@Autowired
	private DefaultPokemonTrainerDao pokemonTrainerDao;
	
	@Override
	public List<Trainer_table_entity> fetchTrainerEntryById(
			int trainer_id_pk) {
		log.info("Wow, we found this trainer: " + trainer_id_pk);
		
		List<Trainer_table_entity> trainerEntry = 
				pokemonTrainerDao.fetchTrainerById(trainer_id_pk);
		
		if(trainerEntry.isEmpty()) {
			String msg = String.format("No Trainer matches were found");
		
		
		throw new NoSuchElementException(msg);
		}
		
	//	Collections.sort(pokemonEntry);
		
		return trainerEntry;
		 
	}

}
