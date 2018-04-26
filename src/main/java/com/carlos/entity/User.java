package com.carlos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User{

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
	private Long id;
    
    @Column(name = "username", unique=true, length = 50, nullable = false)
    private String name;
    
    @Column(name = "password", length = 200, nullable = false)
    private String senha;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_access_roles", 
    	joinColumns = { @JoinColumn(name = "user_id") }, 
    	inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private List<AccessRole> roles;

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<AccessRole> getRoles() {
		return roles;
	}

	public void setRoles(List<AccessRole> roles) {
		this.roles = roles;
	}
    
    
}
