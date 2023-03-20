package pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//using lombok to make our get and set methods for us
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerTableEntity {
	
	private int trainer_id_pk;
	private String trainer_name;

}
