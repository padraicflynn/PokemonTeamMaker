package pokemon.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.dao.DefaultPokemonInTeamsDao;
import pokemon.entity.Pokemon_in_teams_entity;
 

@Slf4j
@Service
public class DefaultPokemonInTeamsService implements PokemonInTeamsService{
	
	@Autowired
	private DefaultPokemonInTeamsDao pokemonInTeamsDao;
	
	@Override
	public List<Pokemon_in_teams_entity> fetchPokemonInTeamsById(int pokemon_in_teams_pk) {
		log.info("There a bunch of trainer owned pokemon here! " + pokemon_in_teams_pk);
		
		List<Pokemon_in_teams_entity> pokemonInTeamsEntry = pokemonInTeamsDao.fetchPokemonInTeamsById(pokemon_in_teams_pk);
		
		if(pokemonInTeamsEntry.isEmpty()) {
			String msg = String.format("No team or Pokemon in a team were found, is there one made?");
			
			throw new NoSuchElementException(msg);
		}
		return pokemonInTeamsEntry;
	}
 

	 

}
