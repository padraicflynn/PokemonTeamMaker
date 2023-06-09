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
import pokemon.entity.PokemonTypeEnum;

@Component
@Slf4j

// Here we work with the Pokémon in teams table. We mainly add team members one at a time.
// We can also see the made teams and most of the info. The trainer table had some trouble 
// with the join statements, stretch goal: get the trainer name to show up when reading
// the made teams. As of this writing we see the trainer FK, which tells us
// what trainer owns the team, so we know which trainer owns which teams. 
// In the USER MADE TEAMS table we can see the trainer name, so it works there at least. 
// You see some later attempts at a full join near the bottom, but not there yet. 

public class DefaultPokemonInTeamsDao implements PokemonInTeamsDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public PokemonInTeamsEntity addPokemonToTeam(int team_name_fk, int pokemon_pk_fk) {
		String sql = ""
				+ "INSERT INTO pokemon_in_teams (team_name_fk, pokemon_pk_fk) VALUES (:team_name_fk, :pokemon_pk_fk)";
		
				Map<String, Object> params = new HashMap<>();
				params.put("team_name_fk", team_name_fk);
				params.put("pokemon_pk_fk", pokemon_pk_fk);
				
				jdbcTemplate.update(sql, params);
				return PokemonInTeamsEntity.builder().team_name_fk(team_name_fk).pokemon_pk_fk(pokemon_pk_fk).build();
	}
	
	@Override
	public List<PokemonInTeamsEntity> fetchPokemonInTeamsById(int team_name_fk) {
	 	
		String sql = ""
				+ "SELECT * "
				+ "FROM pokemon_in_teams "
				+ "RIGHT JOIN pokedex_entry ON pokemon_in_teams.pokemon_pk_fk = pokedex_entry.pokemon_pk "
				+ "LEFT JOIN user_made_teams ON pokemon_in_teams.team_name_fk = user_made_teams.team_name_pk "
			// Maybe full join user made team and trainer table then into pokemon in teams.
			//	+ "LEFT JOIN trainer_table ON user_made_teams.trainer_id_fk = trainer_table.trainder_id_pk "
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
						.pokemon_name(rs.getString("pokemon_name"))
						.team_name(rs.getString("team_name"))
						.team_name_pk(rs.getInt("team_name_pk"))
						.pokemon_type(PokemonTypeEnum.valueOf(rs.getString("pokemon_type")))
					//	.trainer_id_fk(rs.getInt("trainer_id_fk"))
					//	.trainer_name((rs.getString("trainer_name")))
						.build();
			}});
		 
	}
}
