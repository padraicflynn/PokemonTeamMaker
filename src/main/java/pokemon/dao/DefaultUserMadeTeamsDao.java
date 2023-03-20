package pokemon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pokemon.entity.UserMadeTeamsEntity;

// the component scanner is useful as it helps me when builder other classes to call back on component classes
@Component
@Slf4j
public class DefaultUserMadeTeamsDao implements UserMadeTeamsDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<UserMadeTeamsEntity> fetchUserMadeTeamsByID(int team_name_pk) {
		 
		// formatter:off
		
				String sql = ""
						+ "SELECT * "
						+ "FROM user_made_teams "
						+ "WHERE team_name_pk = :team_name_pk ";
		// formatter:on
				
				Map<String, Object> params = new HashMap<>();
				params.put("team_name_pk", team_name_pk);
				
				return jdbcTemplate.query(sql, params, new RowMapper<>() {
					
					 @Override
					 public UserMadeTeamsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
						 // formatter:off
						 return UserMadeTeamsEntity.builder()
								 .team_name_pk(rs.getInt("team_name_pk"))
								 .team_name(rs.getString("team_name"))
								 .trainer_id_fk(rs.getInt("trainer_id_fk"))
								 .description(rs.getString("description"))
								 .build();
					 }});
					 }
		
 
	 

	
	

// create user made teams
	@Override
	public UserMadeTeamsEntity createTeam(String team_name, int trainer_id_fk, String description) {
log.info("DAO: team_name={}, trainer_id_fk={}, description={}", team_name, trainer_id_fk, description);
		
		//@formatter:off
		String sql = ""
				+ "INSERT INTO user_made_teams ("
				+ "team_name, trainer_id_fk, description"
				+ ") VALUES (" 
				+ ":team_name, :trainer_id_fk, :description)";
		
		//@ formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("team_name",  team_name);
		params.put("trainer_id_fk", trainer_id_fk);
		params.put("description", description);
		
		jdbcTemplate.update(sql, params);
		return UserMadeTeamsEntity.builder().team_name(team_name).trainer_id_fk(trainer_id_fk).description(description).build();
		//@formatter:on
	}

 
	
//package end
}
