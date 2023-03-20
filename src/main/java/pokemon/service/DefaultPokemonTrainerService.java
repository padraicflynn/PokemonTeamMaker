package pokemon.service;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pokemon.controller.TrainerOperation;
import pokemon.dao.DefaultPokemonTrainerDao;
import pokemon.entity.PokedexEntryEntity;
import pokemon.entity.TrainerTableEntity;

//SLf4j lets us use the log statements to see things in the console as we go!
@Slf4j
@Service
public class DefaultPokemonTrainerService implements PokemonTrainerService{

	@Autowired
	private DefaultPokemonTrainerDao pokemonTrainerDao;
	
	@Override
	public List<TrainerTableEntity> fetchTrainerEntryById(
			int trainer_id_pk) {
		log.info("Wow, we found this trainer: " + trainer_id_pk);
		
		List<TrainerTableEntity> trainerEntry = 
				pokemonTrainerDao.fetchTrainerById(trainer_id_pk);
		
		if(trainerEntry.isEmpty()) {
			String msg = String.format("No Trainer matches were found");
		
		
		throw new NoSuchElementException(msg);
		}
		
	//	Collections.sort(pokemonEntry);
		
		return trainerEntry;
		 
	}

	/*
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//Trying to make a way to make a trainer
	public class NewTeamTrainer {
	private String newTrainer;
	private String newDescription;
	private String newTeam;
	private TrainerOperation operation;
	
	
	public TrainerOperation getOperation() {
		return operation;
	}
	
	public void setOperation(TrainerOperation operation) {
		this.operation = operation;
	}

	public String getNewTrainer() {
		return newTrainer;
	}

	public void setNewTrainer(String newTrainer) {
		this.newTrainer = newTrainer;
	}

	public String getNewDescription() {
		return newDescription;
	}

	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
	}

	public String getNewTeam() {
		return newTeam;
	}

	public void setNewTeam(String newTeam) {
		this.newTeam = newTeam;
	}
	//newtrainer class end
	}


	 
	//!!!!!!!
	*/
	
	
//package end
}
