package pokemon.dao;

import java.util.List;

import pokemon.entity.TrainerTableEntity;

public interface PokemonTrainerDao {

	List<TrainerTableEntity> fetchTrainerById(int trainer_id_pk);
	
}
