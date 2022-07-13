package acme.entities.patronageReport;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.patonages.Patronages;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;





@Entity
@Getter
@Setter
public class PatronageReport extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date					creationMoment;
	
	
	@Length(min=1, max=256)
	@NotBlank
	protected String				memorandum;
	
	
	@URL
	protected String				link;

	// Derived attributes -----------------------------------------------------
	
	public String getSequenceNumber() {
		final NumberFormat serialNumber = new DecimalFormat("0000");
		return this.patronage.getCode() + ":" + serialNumber.format(this.id);
	}

	// Relationships ----------------------------------------------------------

	
	
	@Valid
	@ManyToOne
	private Patronages patronage;

}
