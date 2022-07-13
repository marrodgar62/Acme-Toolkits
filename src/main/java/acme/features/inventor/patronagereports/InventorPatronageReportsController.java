package acme.features.inventor.patronagereports;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronageReport.PatronageReport;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorPatronageReportsController extends AbstractController<Inventor, PatronageReport> {

	// Internal state ---------------------------------------------------------
	
		@Autowired
		protected InventorPatronageReportsListMineService	listMineService;
		
		@Autowired
		protected InventorPatronageReportsShowService	showService;
		
		@Autowired
		protected InventorPatronageReportsCreateService createService;
		
	
		
		// Constructors -----------------------------------------------------------
		
		@PostConstruct
		protected void initialise() {
			super.addCommand("list-mine-reports", "list", this.listMineService);
			super.addCommand("show", this.showService);
			super.addCommand("create", this.createService);

			
		}
	

}
