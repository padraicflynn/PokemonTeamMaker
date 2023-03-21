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
public class PokedexEntryEntity implements Comparable<PokedexEntryEntity>{
	
	// here we set up our entities for the database. this represents all the info in our database,
	// and will take the info from the data base and 
	//make it usable java objects for the other layers to use

	private int pokemon_pk;
	private String pokemon_name;
	private PokemonTypeEnum pokemon_type;
 
	
	 
	// @JsonIgnore
	public int getPokemon_pk() {
		return pokemon_pk;
	}
	
	
	
	@Override
	public int compareTo(PokedexEntryEntity that) {
		 
		
		// Formatter:off
		return Comparator
				.comparing(PokedexEntryEntity::getPokemon_pk)
				.thenComparing(PokedexEntryEntity::getPokemon_name)
				.thenComparing(PokedexEntryEntity::getPokemon_type)
				.compare(this,  that);
	}
	
	// formatter:on
	 
	
}
//class end