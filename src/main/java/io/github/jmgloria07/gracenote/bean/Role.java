package io.github.jmgloria07.gracenote.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String role;

	@OneToMany
	private List<Resource> accessibleResources;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Resource> getAccessibleResources() {
		return accessibleResources;
	}

	public void setAccessibleResources(List<Resource> accessibleResources) {
		this.accessibleResources = accessibleResources;
	}
}
