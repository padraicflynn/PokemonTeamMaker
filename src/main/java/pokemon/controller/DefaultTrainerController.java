package pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.TrainerTableEntity;
import pokemon.service.PokemonTrainerService;


@RestController
public class DefaultTrainerController implements PokemonTrainerController{
	
	@Autowired
	private PokemonTrainerService pokemonTrainerService;
	
	//Get/Read trainers
	@Override
	public List<TrainerTableEntity> fetchTrainerEntryById(int trainer_id_pk) {
		
		return pokemonTrainerService.fetchTrainerEntryById(trainer_id_pk);
	}
 

	 

	 
	 

}
