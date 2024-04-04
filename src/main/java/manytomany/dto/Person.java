package manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private long phone;
	private String address;
	@ManyToMany
	private List<Langauge> list;

}
