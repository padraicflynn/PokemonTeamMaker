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
import pokemon.entity.Pokemon_in_teams_entity;

@Component
@Slf4j
public class DefaultPokemonInTeamsDao implements PokemonInTeamsDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Pokemon_in_teams_entity> fetchPokemonInTeamsById(int pokemon_in_teams_pk) {
		
		//formatter:off
		
		String sql = ""
				+ "SELECT * "
				+ "FROM pokemon_in_teams "
				+ "WHERE pokemon_in_teams_pk = :pokemon_in_teams_pk "; 
		// formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("pokemon_in_teams_pk",  pokemon_in_teams_pk);
		
		return jdbcTemplate.query(sql,  params, new RowMapper<>() {
			
			@Override
			public Pokemon_in_teams_entity mapRow(ResultSet rs, int rowNum) throws SQLException {
				// formatter:off
				return Pokemon_in_teams_entity.builder()
						.pokemon_in_teams_pk(rs.getInt("pokemon_in_teams_pk"))
						.team_name_fk(rs.getInt("team_name_fk"))
						.pokemon_pk_fk(rs.getInt("pokemon_pk_fk"))
						.build();
			}});
		 
	}
}
