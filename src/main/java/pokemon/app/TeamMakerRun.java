package pokemon.app;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication(scanBasePackageClasses = { pokemon.ComponentScanMarker.class })
public class TeamMakerRun {
  public static void main(String[] args) {
   SpringApplication.run(TeamMakerRun.class, args);
  }
}