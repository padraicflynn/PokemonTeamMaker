package pokemon.service;

import java.util.List;


import pokemon.entity.User_made_teams_entity;

public interface UserMadeTeamsService {

	List<User_made_teams_entity> fetchUserMadeTeamsById(int team_name_pk);

}
