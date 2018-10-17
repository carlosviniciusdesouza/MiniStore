package com.carlos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorization")
public class Authorization implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5892581284757938148L;

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
    
    @Column(name = "name", unique=true, length = 50, nullable = false)
    private String authority; //Never change the name of this field

	public Authorization() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}
    
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
