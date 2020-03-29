package com.pruebajorgecarmona.user.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "phone")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPhone;

	@Column(name = "number", nullable = false)
	private Integer number;
	
	@Column(name = "citycode", nullable = false)
	private int citycode;
	
	@Column(name = "countrycode", nullable = false)
	private String contrycode;
}
