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
public class User_made_teams_entity {

	private int team_name_pk;
	private String team_name;
	private int trainer_id_fk;
	private String description;
	

}
