package acme.entities.patonages;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import acme.roles.Patron;
import lombok.Getter;
import lombok.Setter;




@Entity
@Getter
@Setter
public class Patronages extends AbstractEntity {
	
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	
	// Attributes -------------------------------------------------------------
	
	@NotNull
	private PatronageStatus status;
	
	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	private String code;
	
	@NotBlank
	@Length(min=1, max= 256)
	private String legalStuff;
	
	@Valid
	@NotNull
	private Money budget;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Transient
	@CreatedDate
	private Date creationTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date initPeriod;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date finalPeriod;
	
	@URL
	private String link;
	
	private boolean published;
	
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	private Patron patron;
	
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	private Inventor inventor;
	
	
}
