package pokemon.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pokemon.entity.TrainerTableEntity;

@Component
@Slf4j
public class DefaultPokemonTrainerDao implements PokemonTrainerDao{

 
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<TrainerTableEntity> fetchTrainerById(int trainer_id_pk) {

		// formatter:off
				
				String sql = ""
						+ "SELECT * "
						+ "FROM trainer_table "
						+ "WHERE trainer_id_pk = :trainer_id_pk ";
		// formatter:on
				
				Map<String, Object> params = new HashMap<>();
				params.put("trainer_id_pk", trainer_id_pk);
				
				return jdbcTemplate.query(sql, params, new RowMapper<>() {
					
					@Override
					public TrainerTableEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
						// formatter:off
						return TrainerTableEntity.builder()
								.trainer_id_pk(rs.getInt("trainer_id_pk"))
								.trainer_name(rs.getString("trainer_name"))
								.build();
						
						// formatter:on
					}});
					}
				// formatter:on

	
	
	public TrainerTableEntity createTrainer(String trainer_name) {
		log.info("DAO: trainer_name={}", trainer_name);
	//// formatter:off
		
				String sql = ""
						+ "INSERT INTO trainer_table (trainer_name) VALUES (:trainer_name)";
		
				Map<String, Object> params = new HashMap<>();
				params.put("trainer_name", trainer_name);
				
				jdbcTemplate.update(sql, params);
				return  TrainerTableEntity.builder().trainer_name(trainer_name).build();
				
	}

	@Override
	public TrainerTableEntity deleteTrainer(int trainer_id_pk) {
	//// formatter:off
		
		String sql = ""
					+ "DELETE FROM trainer_table WHERE "
					+ "trainer_id_pk = :trainer_id_pk;";
	
		Map<String, Object> params = new HashMap<>();
		params.put("trainer_id_pk", trainer_id_pk);
		
		jdbcTemplate.update(sql, params);
		return  TrainerTableEntity.builder().trainer_id_pk(trainer_id_pk).build();
			
	
	}
	
	}
	

 
