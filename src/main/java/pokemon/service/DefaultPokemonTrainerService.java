package pokemon.service;

import java.util.List;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
 
import pokemon.dao.DefaultPokemonTrainerDao;
import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.TrainerTableEntity;
import pokemon.entity.UserMadeTeamsEntity;

//SLf4j lets us use the log statements to see things in the console as we go!
@Slf4j
@Service
public class DefaultPokemonTrainerService implements PokemonTrainerService{

	@Autowired
	private DefaultPokemonTrainerDao pokemonTrainerDao;
	
	@Override
	public List<TrainerTableEntity> fetchTrainerEntryById(int trainer_id_pk) {
		log.info("Wow, we found this trainer: " + trainer_id_pk);
		return pokemonTrainerDao.fetchTrainerById(trainer_id_pk);
		 
	}

	@Override
	public TrainerTableEntity deleteTrainer(int trainer_id_pk) {
			log.info("Look, we revoked the license for this trainer: " + trainer_id_pk);	
			return  pokemonTrainerDao.deleteTrainer(trainer_id_pk);
	}

	@Override
	public TrainerTableEntity createTrainer(String trainer_name) {
			log.info("Here is a new trainer we just found(you created): " + trainer_name);
			return pokemonTrainerDao.createTrainer(trainer_name);
	}

	
	
	
//package end
}
