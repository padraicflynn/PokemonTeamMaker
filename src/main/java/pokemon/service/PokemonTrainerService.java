package pokemon.service;

import java.util.List;

import pokemon.entity.Trainer_table_entity;

public interface PokemonTrainerService {

	  List<Trainer_table_entity> fetchTrainerEntryById(int trainer_id_pk);

}
