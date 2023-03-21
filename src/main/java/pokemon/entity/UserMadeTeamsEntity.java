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
public class UserMadeTeamsEntity {

	private int team_name_pk;
	private String team_name;
	private int trainer_id_fk;
	private String description;
	
	//these two are here for the join table/builder to show more info when reading a team
	 private String pokemon_name;
	 private int pokemon_pk_fk;

}
