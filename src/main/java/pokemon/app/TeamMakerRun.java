package pokemon.app;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 

@SpringBootApplication(scanBasePackageClasses = { pokemon.ComponentScanMarker.class })
public class TeamMakerRun {

  public static void main(String[] args) {
   SpringApplication.run(TeamMakerRun.class, args);

  }

}

//http://localhost:8080/swagger-ui.html


 
//
//for mentor session ask about the get on swagger, if you should use the sounds like in the json 


// go to swagger and try to get anything, it is error 500; is the schema not loaded?



// the join table only comes together when people actually make the team right?
// like the pokemon in team will only populate when we add a trainer and their team that has the pokemon in use?