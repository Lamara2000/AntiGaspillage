package com.antigaspillage.demo.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String name;

	
	public Role() {
		
	}

	public Role(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Role(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long idRole) {
		this.id = idRole;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
