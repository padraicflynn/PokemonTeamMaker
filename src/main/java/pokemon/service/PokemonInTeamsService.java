package pokemon.service;

import java.util.List;

import pokemon.entity.PokemonInTeamsEntity;

public interface PokemonInTeamsService {

	List<PokemonInTeamsEntity> fetchPokemonInTeamsById(int team_name_fk);

	PokemonInTeamsEntity addPokemonToTeam(int team_name_fk, int pokemon_pk_fk);

}
