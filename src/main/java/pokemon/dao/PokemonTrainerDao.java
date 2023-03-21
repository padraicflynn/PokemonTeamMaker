package pokemon.dao;

import java.util.List;

import pokemon.entity.TrainerTableEntity;

public interface PokemonTrainerDao {

	/**
	 * 
	 * @param trainer_id_pk
	 * @return
	 */
	List<TrainerTableEntity> fetchTrainerById(int trainer_id_pk);
	
	/**
	 * 
	 * @param trainer_id_pk
	 * @param trainer_name
	 * @return
	 */
	TrainerTableEntity createTrainer(String trainer_name);
	
	/**
	 * 
	 * @param trainer_id_pk
	 * @return
	 */
	TrainerTableEntity deleteTrainer(int trainer_id_pk);
}
