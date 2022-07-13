package acme.entities.artefact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Artefact extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@NotNull
	protected ArtefactType type;
	
	@NotBlank
	@Length(min=1, max = 101)
	protected String name;
	
	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	@NotBlank
	@Length(min=1, max = 101)
	protected String technology;
	
	@NotBlank
	@Length(min=1, max = 256)
	protected String description;
	
	@NotNull
	@Valid
	protected Money retailPrice;
	
	@URL
	protected String moreInfo;

	protected boolean published;
	
	
	
	// Derived attributes -------------------------------------------------------------
	
	// Relationships  -------------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional = false) 
	protected Inventor inventor;

}
