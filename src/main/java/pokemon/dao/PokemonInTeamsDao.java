package pokemon.dao;

import java.util.List;

import pokemon.entity.Pokemon_in_teams_entity;

public interface PokemonInTeamsDao {

	List<Pokemon_in_teams_entity> fetchPokemonInTeamsById(int pokemon_in_teams_pk);

}
