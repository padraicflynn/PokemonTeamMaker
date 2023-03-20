package pokemon.service;

import java.util.List;

import pokemon.entity.TrainerTableEntity;

public interface PokemonTrainerService {

	  List<TrainerTableEntity> fetchTrainerEntryById(int trainer_id_pk);
	   

}
