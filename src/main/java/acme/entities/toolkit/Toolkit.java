package acme.entities.toolkit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Toolkit extends AbstractEntity {
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	// Attributes -------------------------------------------------------------
	
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String code;
	
	@Length(min=1, max = 101)
	@NotBlank
	protected String title;
	
	@Length(min=1, max = 256)
	@NotBlank
	protected String description;
	
	@Length(min=1, max = 256)
	@NotBlank
	protected String assemblyNotes;
	
	@URL
	protected String link;
	
	protected boolean published;

	
	// Derived attributes -----------------------------------------------------
	
	// Relationships ----------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional = false) 
	protected Inventor inventor;

}
