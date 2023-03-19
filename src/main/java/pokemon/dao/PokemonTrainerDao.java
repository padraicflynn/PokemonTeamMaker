package pokemon.dao;

import java.util.List;

import pokemon.entity.Trainer_table_entity;

public interface PokemonTrainerDao {

	List<Trainer_table_entity> fetchTrainerById(int trainer_id_pk);
	
}
