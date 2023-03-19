package pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//using lombok to make our get and set methods for us
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Pokemon_in_teams_entity {

	private int pokemon_in_teams_pk;
	private int team_name_fk;
	private int pokemon_pk_fk;
	
	// here we have the primary key for each pokemon in a team, and the two foreign keys for the user_made_teams table and the pokedex_entry (database) table
	// this is our join table, taking the many to many relationship and making a new object for each pokemon being used
}
