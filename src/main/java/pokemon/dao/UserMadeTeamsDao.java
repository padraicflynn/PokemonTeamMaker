package pokemon.dao;

import java.util.List;

import pokemon.entity.User_made_teams_entity;

public interface UserMadeTeamsDao {

	List<User_made_teams_entity> fetchUserMadeTeamsByID(int team_name_pk);

}
