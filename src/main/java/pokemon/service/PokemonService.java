package pokemon.service;

import java.util.List;

import pokemon.entity.Pokedex_entry_entity;
import pokemon.entity.Pokemon_type_enum;

public interface PokemonService {

	
	 
	List<Pokedex_entry_entity> fetchPokedexEntry(int pokemon_pk, String pokemon_name, Pokemon_type_enum pokemon_type);

	List<Pokedex_entry_entity> fetchPokedexEntryByID(int pokemon_pk);

	List<Pokedex_entry_entity> fetchPokedexEntryByType(Pokemon_type_enum pokemon_type);

	List<Pokedex_entry_entity> fetchPokedexEntryByName(String pokemon_name);
}
