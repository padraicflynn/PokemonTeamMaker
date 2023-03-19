package pokemon.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.dao.DefaultUserMadeTeamsDao;
import pokemon.entity.User_made_teams_entity;

// SLf4j lets us use the log statements to see things in the console as we go!
@Slf4j
@Service
public class DefaultUserMadeTeamsService implements UserMadeTeamsService{
	
	@Autowired
	private DefaultUserMadeTeamsDao userMadeTeamsDao;

	@Override
	public List<User_made_teams_entity> fetchUserMadeTeamsById(int team_name_pk) {
		 log.info("Hey, here is a team that was requested! " + team_name_pk);
		 //I like seeing the items we request pop up in the console so I use log statements for each.
		 
		 List<User_made_teams_entity> userMadeTeamsEntry = userMadeTeamsDao.fetchUserMadeTeamsByID(team_name_pk);
		 
		 if(userMadeTeamsEntry.isEmpty()) {
			 String msg = String.format("No team matches were found");
			 
			 throw new NoSuchElementException(msg);
			 
		 }
				 return userMadeTeamsEntry;
	}

}
