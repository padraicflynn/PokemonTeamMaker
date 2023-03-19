package pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import pokemon.entity.Pokemon_in_teams_entity;
import pokemon.service.PokemonInTeamsService;

@RestController
public class DefaultPokemonInTeamsController implements PokemonInTeamsController{

	
	@Autowired
	private PokemonInTeamsService pokemonInTeamsService;
	
	@Override
	public List<Pokemon_in_teams_entity> fetchPokemonInTeamsById(int pokemon_in_teams_pk) {
		return pokemonInTeamsService.fetchPokemonInTeamsById(pokemon_in_teams_pk);
	}
}
