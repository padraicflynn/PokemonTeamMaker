package pokemon.service;

import java.util.List;
import java.util.Optional;

import pokemon.entity.UserMadeTeamsEntity;

public interface UserMadeTeamsService {

 
	List<UserMadeTeamsEntity> fetchUserMadeTeamsById(int team_name_pk);
  
	UserMadeTeamsEntity createTeam(String team_name, int trainer_id_fk, String description);

	UserMadeTeamsEntity updateTeam(String team_name, int trainer_id_fk, String description, int team_name_pk);

	UserMadeTeamsEntity deleteTeam(int team_name_pk);
	
	
	
}
