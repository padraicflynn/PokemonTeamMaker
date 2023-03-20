package pokemon.dao;

import java.util.List;


import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.PokemonTypeEnum;

public interface PokedexEntryDao {

	
	List<PokedexEntryEntity> fetchPokedexEntry(int pokemon_pk, String pokemon_name, PokemonTypeEnum pokemon_type);
	
	
	List<PokedexEntryEntity> fetchPokedexEntryByID(int pokemon_pk);
	
	List<PokedexEntryEntity> fetchPokedexEntryByName(String pokemon_name);
	
	List<PokedexEntryEntity> fetchPokedexEntryByType(PokemonTypeEnum pokemon_type);
	
}
