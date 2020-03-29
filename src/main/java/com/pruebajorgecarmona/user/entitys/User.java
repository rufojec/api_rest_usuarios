package com.pruebajorgecarmona.user.entitys;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uiid;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity = Phone.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "uiid",referencedColumnName = "uiid")
	private List<Phone> phones;
	
	@Column(name = "created", nullable = false)
	private Date created = new Date();
	
	@Column(name = "modified", nullable = true)
	private Date modified;
}
