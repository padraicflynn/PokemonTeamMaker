package pokemon.service;

import java.util.List;

import pokemon.entity.TrainerTableEntity;
import pokemon.entity.UserMadeTeamsEntity;

public interface PokemonTrainerService {

	List<TrainerTableEntity> fetchTrainerEntryById(int trainer_id_pk);

	TrainerTableEntity deleteTrainer(int trainer_id_pk);

	TrainerTableEntity createTrainer(String trainer_name);
	   

}
