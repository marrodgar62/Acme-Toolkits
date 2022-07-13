/*
 * ExchangeRate.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.entities.systemConfiguration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExchangeRate extends AbstractEntity{

	// Attributes -------------------------------------------------------------
	
	private static final long serialVersionUID = 1L;
	
	public Double	          	rate;
	
	@Column(unique = true)
	public String				baseTarget;
	
	public Date					date;
	
}