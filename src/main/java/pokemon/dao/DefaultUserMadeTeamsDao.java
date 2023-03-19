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
import pokemon.entity.User_made_teams_entity;

// the component scanner is useful as it helps me when builder other classes to call back on component classes
@Component
@Slf4j
public class DefaultUserMadeTeamsDao implements UserMadeTeamsDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<User_made_teams_entity> fetchUserMadeTeamsByID(int team_name_pk) {
		 
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
					 public User_made_teams_entity mapRow(ResultSet rs, int rowNum) throws SQLException {
						 // formatter:off
						 return User_made_teams_entity.builder()
								 .team_name_pk(rs.getInt("team_name_pk"))
								 .team_name(rs.getString("team_name"))
								 .trainer_id_fk(rs.getInt("trainer_id_fk"))
								 .description(rs.getString("description"))
								 .build();
					 }});
					 }
		
 

	
	//package end
}
