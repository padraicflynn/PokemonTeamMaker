package pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import pokemon.entity.User_made_teams_entity;
import pokemon.service.UserMadeTeamsService;


@RestController
public class DefaultUserMadeTeamsController implements UserMadeTeamsController{
	
	@Autowired
	private UserMadeTeamsService userMadeTeamsService;
	
	//Get/Read user made teams, two premade
	@Override
	public List<User_made_teams_entity> fetchUserMadeTeamsById(int team_name_pk) {
		
		return userMadeTeamsService.fetchUserMadeTeamsById(team_name_pk);
		
	}

}
