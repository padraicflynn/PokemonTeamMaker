package pokemon.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.dao.DefaultPokemonInTeamsDao;
import pokemon.entity.PokemonInTeamsEntity;
 

@Slf4j
@Service
public class DefaultPokemonInTeamsService implements PokemonInTeamsService{
	
	@Autowired
	private DefaultPokemonInTeamsDao pokemonInTeamsDao;
	
//get team
	@Override
	public List<PokemonInTeamsEntity> fetchPokemonInTeamsById(int team_name_fk) {
		log.info("There a bunch of trainer owned pokemon here! " + team_name_fk);
		
		List<PokemonInTeamsEntity> pokemonInTeamsEntry = pokemonInTeamsDao.fetchPokemonInTeamsById(team_name_fk);
		
		if(pokemonInTeamsEntry.isEmpty()) {
			String msg = String.format("No team or Pokemon in a team were found, is there one made?");
			
			throw new NoSuchElementException(msg);
		}
		return pokemonInTeamsEntry;
	}

//post/add to team
	@Override
	public PokemonInTeamsEntity addPokemonToTeam(int team_name_fk, int pokemon_pk_fk) {
		log.info("We are adding some new team members!" + pokemon_pk_fk);
		return pokemonInTeamsDao.addPokemonToTeam(team_name_fk, pokemon_pk_fk);
	}
 

	 

}
