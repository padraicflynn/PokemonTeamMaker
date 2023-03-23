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


//Here is our Data Access Object layer. We use JDBC template to use named parameter instead of '?' place holders,
// which we will use with our sql statements that ask the database for info, then we use 
// a hash map to assign the returned info to a key/value, and the value is used in a builder which
// is returned in the method we use/call. 
@Component
@Slf4j
public class DefaultPokedexEntryDao implements PokedexEntryDao{
	 
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	 
	// method to read list of Pokémon from pokedex_entry table
	@Override
	public List<PokedexEntryEntity> fetchPokedexEntry
	(int pokemon_pk, String pokemon_name, PokemonTypeEnum pokemon_type) {
		 
		// @formatter:off
		
		String sql = ""
				+ "SELECT * " 
				+ "FROM pokedex_entry "
				+ "WHERE pokemon_name = :pokemon_name AND pokemon_type = :pokemon_type";
	 
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

	// Here we search the Pokédex by the ID number.
	public List<PokedexEntryEntity> fetchPokedexEntryByID(int pokemon_pk) {
		/// @formatter:off
		
		String sql = ""
				+ "SELECT * " 
				+ "FROM pokedex_entry "
				+ "WHERE pokemon_pk = :pokemon_pk ";
 
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
  
	//  Searching by a name. 
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
 
	
	// Types are in an enum, so we convert that to a String before using the builder. 
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


