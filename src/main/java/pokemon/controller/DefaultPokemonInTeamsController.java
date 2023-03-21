package pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import pokemon.entity.PokemonInTeamsEntity;
import pokemon.service.PokemonInTeamsService;

@RestController
public class DefaultPokemonInTeamsController implements PokemonInTeamsController{

	
	@Autowired
	private PokemonInTeamsService pokemonInTeamsService;
	
	@Override
	public List<PokemonInTeamsEntity> fetchPokemonInTeamsById(int team_name_fk) {
		return pokemonInTeamsService.fetchPokemonInTeamsById(team_name_fk);
	}
	
	public PokemonInTeamsEntity addPokemonToTeam(int team_name_fk, int pokemon_pk_fk) {
		return pokemonInTeamsService.addPokemonToTeam(team_name_fk, pokemon_pk_fk);
	}
}
