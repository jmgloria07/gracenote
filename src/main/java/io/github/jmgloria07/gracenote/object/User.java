package io.github.jmgloria07.gracenote.object;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OrderBy("dateCreated DESC")
	@OneToMany(mappedBy = "user")
	private List<Grace> graces;
	
	public User() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Grace> getGraces() {
		return graces;
	}

	public void setGraces(List<Grace> graces) {
		this.graces = graces;
	}
}
