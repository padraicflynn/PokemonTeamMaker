package pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//using lombok to make our get and set methods for us
@Data
@Builder
@AllArgsConstructor

public class PokemonInTeamsEntity {

//	private int pokemon_in_teams_pk;
	private int team_name_fk;
	private int pokemon_pk_fk;
	
	// The above three are exclusive to the Pokemon in teams table, however I want to join the other tables into this one so when you 
	// read a team it will have all of the info we've ever put into a team. Maybe I should have made one entity table,
	// as the other entity tables have these variables that are somewhat exclusive to their tables
	// but I am making this feature late in the development of this App, so this seemed like
	//the path of least resistance. 
	private String pokemon_name;
	private String team_name;
//	private String trainer_name;
	 
	private int team_name_pk;
	private PokemonTypeEnum pokemon_type;
//	private int trainer_id_fk;

}
