package pokemon.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//using Lombok to make our get and set methods for us

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokedex_entry_entity implements Comparable<Pokedex_entry_entity>{
	
	// here we set up our entities for the database. this represents all the info in our database,
	// and will take the info from the data base and 
	//make it usable java objects for the other layers to use

	private int pokemon_pk;
	private String pokemon_name;
	private Pokemon_type_enum pokemon_type;
//	private Pokemon_type_enum pokemon_type2;
	
	 
	// @JsonIgnore
	public int getPokemon_pk() {
		return pokemon_pk;
	}
	
	
	
	@Override
	public int compareTo(Pokedex_entry_entity that) {
		 
		
		// Formatter:off
		return Comparator
				.comparing(Pokedex_entry_entity::getPokemon_pk)
				.thenComparing(Pokedex_entry_entity::getPokemon_name)
				.thenComparing(Pokedex_entry_entity::getPokemon_type)
				.compare(this,  that);
	}
	
	// formatter:on
	 
	
}
//class end