package pokemon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pokemon.entity.PokemonInTeamsEntity;

@Component
@Slf4j
public class DefaultPokemonInTeamsDao implements PokemonInTeamsDao{
	
	
	
	/*
	public void getPokemonName() {
		return pokemon_name
	}
	*/
	
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<PokemonInTeamsEntity> fetchPokemonInTeamsById(int team_name_fk) {
		
		//formatter:off
		
		String sql = ""
				+ "SELECT * "
				+ "FROM pokemon_in_teams "
				+ "WHERE team_name_fk = :team_name_fk "; 
		// formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("team_name_fk",  team_name_fk);
		
		return jdbcTemplate.query(sql,  params, new RowMapper<>() {
			
			@Override
			public PokemonInTeamsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				// formatter:off
				return PokemonInTeamsEntity.builder()
						
						.team_name_fk(rs.getInt("team_name_fk"))
						.pokemon_pk_fk(rs.getInt("pokemon_pk_fk"))
						.build();
			}});
		 
	}
}
