package pokemon.dao;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.PokemonTypeEnum;


@Component
@Slf4j
public class DefaultPokedexEntryDao implements PokedexEntryDao{
	
	
	 
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	 
	
	// method to read list of pokemon from pokedex_entry table
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntry
	(int pokemon_pk, String pokemon_name, PokemonTypeEnum pokemon_type) {
		 
		// @formatter:off
		
		String sql = ""
				+ "SELECT * " 
				+ "FROM pokedex_entry "
				+ "WHERE pokemon_name = :pokemon_name AND pokemon_type = :pokemon_type";
		// @formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("pokemon_name", pokemon_name);
		params.put("pokemon_type", pokemon_type.toString());
	
			
		
		
		return jdbcTemplate.query(sql, params,
				new RowMapper<>() {
			
			@Override
			public PokedexEntryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return PokedexEntryEntity.builder()
						.pokemon_pk(rs.getInt("pokemon_pk"))
						.pokemon_name(rs.getString("pokemon_name"))
						.pokemon_type(PokemonTypeEnum.valueOf(rs.getString("pokemon_type")))
						.build();
				
				// @formatter:on
			}});
			
		}

	// !!!!!!!! Pokemon by ID !!!!!!!
	public List<PokedexEntryEntity> fetchPokedexEntryByID(int pokemon_pk) {
		/// @formatter:off
		
		String sql = ""
				+ "SELECT * " 
				+ "FROM pokedex_entry "
				+ "WHERE pokemon_pk = :pokemon_pk ";
		// @formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("pokemon_pk", pokemon_pk);
		
		return jdbcTemplate.query(sql, params,
				new RowMapper<>() {
			
			@Override
			public PokedexEntryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return PokedexEntryEntity.builder()
						.pokemon_pk(rs.getInt("pokemon_pk"))
						.pokemon_name(rs.getString("pokemon_name"))
						.pokemon_type(PokemonTypeEnum.valueOf(rs.getString("pokemon_type")))
						.build();
				
				// @formatter:on
			}});
	}

	// !!!!!!!!! End Pokemon by ID !!!!!!!!!!!!!
	
	// !!!!!!!!!!!!!! Pokemon team by name !!!!!!!!!!!!!!!!!!!!!!!!
	
	public List<PokedexEntryEntity> fetchPokedexEntryByName(String pokemon_name) {
		/// @formatter:off
		
				String sql = ""
						+ "SELECT * " 
						+ "FROM pokedex_entry "
						+ "WHERE pokemon_name = :pokemon_name ";
				// @formatter: on
				
				Map<String, Object> params = new HashMap<>();
				params.put("pokemon_name", pokemon_name);
							
					
				
				
				return jdbcTemplate.query(sql, params,
						new RowMapper<>() {
					
					@Override
					public PokedexEntryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
						// @formatter:off
						return PokedexEntryEntity.builder()
								.pokemon_pk(rs.getInt("pokemon_pk"))
								.pokemon_name(rs.getString("pokemon_name"))
								.pokemon_type(PokemonTypeEnum.valueOf(rs.getString("pokemon_type")))
								.build();
						
						// @formatter:on
					}});
	}

	// End pokemon by name !!!
	// !!!!! Pokemon by type!!!!
	
	public List<PokedexEntryEntity> fetchPokedexEntryByType(PokemonTypeEnum pokemon_type) {
		/// @formatter:off
		
		String sql = ""
				+ "SELECT * " 
				+ "FROM pokedex_entry "
				+ "WHERE pokemon_type = :pokemon_type ";
		// @formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("pokemon_type", pokemon_type.toString());
		 
					
			
		
		
		return jdbcTemplate.query(sql, params,
				new RowMapper<>() {
			//num row for this may be more than one?
			@Override
			
			public PokedexEntryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return PokedexEntryEntity.builder()
						.pokemon_pk(rs.getInt("pokemon_pk"))
						.pokemon_name(rs.getString("pokemon_name"))
						.pokemon_type(PokemonTypeEnum.valueOf(rs.getString("pokemon_type")))
						.build();
				
				// @formatter:on
			}});
	}
			
	
	
	// end package
	}


