package pokemon.service;

import java.util.List;

import pokemon.entity.Pokemon_in_teams_entity;

public interface PokemonInTeamsService {

	List<Pokemon_in_teams_entity> fetchPokemonInTeamsById(int pokemon_in_teams_pk);

}
