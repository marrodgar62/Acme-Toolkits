package acme.features.inventor.patronages;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patonages.Patronages;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorPatronagesController extends AbstractController<Inventor, Patronages> {
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorPatronagesListMineService	listMineService;
	
	@Autowired
	protected InventorPatronagesShowService	showService;
	
	@Autowired
	protected InventorPatronagesUpdate updateService;
	
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list-mine", "list", this.listMineService);
		super.addCommand("show", this.showService);
		super.addCommand("update", this.updateService);
	}
}
