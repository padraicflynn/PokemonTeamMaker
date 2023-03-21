package pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.TrainerTableEntity;
import pokemon.entity.UserMadeTeamsEntity;
import pokemon.service.PokemonTrainerService;

@Slf4j
@RestController
public class DefaultTrainerController implements PokemonTrainerController{
	
	@Autowired
	private PokemonTrainerService pokemonTrainerService;
	
	//Get/Read trainers
	@Override
	public List<TrainerTableEntity> fetchTrainerEntryById(int trainer_id_pk) {
		
		return pokemonTrainerService.fetchTrainerEntryById(trainer_id_pk);
	}	

  	

	
//create trainer
	@Override
	public TrainerTableEntity createTrainer(String trainer_name) {
		log.info("trainer_id_pk={}, trainer_name={}");
		return pokemonTrainerService.createTrainer(trainer_name);
	}

	@Override
	public TrainerTableEntity deleteTrainer(int trainer_id_pk) {
		log.info("trainer_id_pk={}");
		return pokemonTrainerService.deleteTrainer(trainer_id_pk);
		 
	}
 

	 

	 
	 
//end package
}
