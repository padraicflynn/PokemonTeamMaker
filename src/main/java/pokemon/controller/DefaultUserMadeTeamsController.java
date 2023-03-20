package pokemon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pokemon.entity.UserMadeTeamsEntity;
import pokemon.service.UserMadeTeamsService;

@Slf4j
@RestController
public class DefaultUserMadeTeamsController implements UserMadeTeamsController{
	
	@Autowired
	private UserMadeTeamsService userMadeTeamsService;
	
	//Get/Read user made teams, two premade
	@Override
	public List<UserMadeTeamsEntity> fetchUserMadeTeamsById(int team_name_pk) {
		
		return userMadeTeamsService.fetchUserMadeTeamsById(team_name_pk);
		
	}

//!!! end read team
	
//!!! create team
	@Override
	public UserMadeTeamsEntity createTeam(String team_name, int trainer_id_fk, String description) {
		log.info("team_name={}, trainer_id_fk= {}, description{}");
		return userMadeTeamsService.createTeam(team_name, trainer_id_fk, description);
	 }
//!!!end create team
	
	
//end package 


	
	}
