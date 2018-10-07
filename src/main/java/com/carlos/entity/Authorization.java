package com.carlos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "authorization")

public class Authorization implements GrantedAuthority {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "authorization_id")
	private Long id;
    
    @Column(name = "authorization_name", unique=true, length = 50, nullable = false)
    private String name;

	public Authorization() {
		super();
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return this.name;
	}
    
}
