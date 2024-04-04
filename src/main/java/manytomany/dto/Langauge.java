package manytomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter
@Entity
public class Langauge {
	@Id
	private int id;
	private String name;
	private String origin;

}
