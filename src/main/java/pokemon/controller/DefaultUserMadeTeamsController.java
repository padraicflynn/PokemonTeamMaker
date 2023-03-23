package pokemon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pokemon.entity.UserMadeTeamsEntity;
import pokemon.service.UserMadeTeamsService;

@Slf4j
@RestController
public class DefaultUserMadeTeamsController implements UserMadeTeamsController{
	
	@Autowired
	private UserMadeTeamsService userMadeTeamsService;
	
	
//Get/Read user made teams, two are premade for testing and showing off populating the table.
	@Override
	public List<UserMadeTeamsEntity> fetchUserMadeTeamsById(int team_name_pk) {
		
		return userMadeTeamsService.fetchUserMadeTeamsById(team_name_pk);
		
	}
 
//create team
	@Override
	public UserMadeTeamsEntity createTeam(String team_name, int trainer_id_fk, String description) {
		log.info("team_name={}, trainer_id_fk={}, description{}");
		return userMadeTeamsService.createTeam(team_name, trainer_id_fk, description);
	 }
 
// update a team:
@Override
	public UserMadeTeamsEntity updateTeam(String team_name, int trainer_id_fk, String description, int team_name_pk) {
		log.info("team_name={}, trainer_id_fk={}", "description{}");
		return userMadeTeamsService.updateTeam(team_name, trainer_id_fk, description, team_name_pk);
	}
  
// delete a team:
	@Override
	public UserMadeTeamsEntity deleteTeam(int team_name_pk) {
		 log.info("team_name_pk={}");
		return userMadeTeamsService.deleteTeam(team_name_pk);
	}
 
//end package 
	}
