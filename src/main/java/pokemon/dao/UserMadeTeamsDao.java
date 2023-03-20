package pokemon.dao;

import java.util.List;
import java.util.Optional;

import pokemon.entity.UserMadeTeamsEntity;

public interface UserMadeTeamsDao {

	
	//read teams
	/**
	 * 
	 * @param team_name_pk
	 * @return
	 */
	List<UserMadeTeamsEntity> fetchUserMadeTeamsByID(int team_name_pk);
	
	//create teams
	/**
	 * 
	 * @param team_name
	 * @param trainer_id_fk
	 * @param description
	 * @return
	 */
	UserMadeTeamsEntity createTeam(String team_name, int trainer_id_fk, String description);

	/**
	 * 
	 * @param team_name
	 * @param trainer_id_fk
	 * @param description
	 * @return
	 */
	UserMadeTeamsEntity updateTeam(String team_name, int trainer_id_fk, String description, int team_name_pk);

	/**
	 * 
	 * @param team_name_pk
	 * @return
	 */
	UserMadeTeamsEntity deleteTeam(int team_name_pk);



 

}
