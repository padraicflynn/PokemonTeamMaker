package pokemon.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.dao.DefaultUserMadeTeamsDao;
import pokemon.dao.UserMadeTeamsDao;
import pokemon.entity.UserMadeTeamsEntity;

// SLf4j lets us use the log statements to see things in the console as we go!
@Slf4j
@Service
public class DefaultUserMadeTeamsService implements UserMadeTeamsService{
	
	@Autowired
	private DefaultUserMadeTeamsDao userMadeTeamsDao;

	@Override
	public List<UserMadeTeamsEntity> fetchUserMadeTeamsById(int team_name_pk) {
		 log.info("Hey, here is a team that was requested! " + team_name_pk);
		 //I like seeing the items we request pop up in the console so I use log statements for each.
		 
		 List<UserMadeTeamsEntity> userMadeTeamsEntry = userMadeTeamsDao.fetchUserMadeTeamsByID(team_name_pk);
		 
		 if(userMadeTeamsEntry.isEmpty()) {
			 String msg = String.format("No team matches were found");
			 
			 throw new NoSuchElementException(msg);
			 
		 }
				 return userMadeTeamsEntry;
	}

	//create user made team
	@Override
	public  UserMadeTeamsEntity createTeam(String team_name, int trainer_id_fk, String description) {
		log.info("The create team method was called with team_name={}, trainer_id_fk={}, description={}", team_name, trainer_id_fk, description);
		
		return userMadeTeamsDao.createTeam(team_name, trainer_id_fk, description);
	}

	@Override
	public UserMadeTeamsEntity updateTeam(String team_name, int trainer_id_fk, String description, int team_name_pkl) {
		log.info("The update team method was envoked with team_name={}, trainer_id_fk={}, description={}", team_name, trainer_id_fk, description);
		return userMadeTeamsDao.updateTeam(team_name, trainer_id_fk, description, team_name_pkl);
	}

	@Override
	public UserMadeTeamsEntity deleteTeam(int team_name_pk) {
		log.info("The update team method was envoked with team_name_pk={}", team_name_pk);
		return userMadeTeamsDao.deleteTeam(team_name_pk);
	}
	
}
