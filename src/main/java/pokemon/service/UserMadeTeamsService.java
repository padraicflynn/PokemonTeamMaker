package pokemon.service;

import java.util.List;
import java.util.Optional;

import pokemon.entity.UserMadeTeamsEntity;

public interface UserMadeTeamsService {

	//!!!Read/Fetch user made team
	List<UserMadeTeamsEntity> fetchUserMadeTeamsById(int team_name_pk);
	//!!!

	UserMadeTeamsEntity createTeam(String team_name, int trainer_id_fk, String description);
	
	//!!!
	
}
