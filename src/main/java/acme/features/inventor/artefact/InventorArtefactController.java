package acme.features.inventor.artefact;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.artefact.Artefact;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorArtefactController extends AbstractController<Inventor, Artefact> {
	
	// Internal state ---------------------------------------------------------

		@Autowired 
		protected InventorComponentAndToolsByToolkitListService componentAndToolByToolkitService;
		
		@Autowired
		protected InventorArtefactShowService	showService;
		
		@Autowired
		protected InvertorArtefactListService	ownListService;
		
		@Autowired
		protected InventorArtefactCreateService createService;
		
		@Autowired
		protected InventorArtefactPublishService publishService;
		
		@Autowired
		protected InventorArtefactDeleteService deleteService;
		
		@Autowired
		protected InventorArtefactUpdateService updateService;

	// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("show", this.showService);
			super.addCommand("list-mine", "list", this.ownListService);
			super.addCommand("list-artefact-toolkit", "list", this.componentAndToolByToolkitService);
			super.addCommand("create", this.createService);
			super.addCommand("publish", "update" ,this.publishService);
			super.addCommand("delete",this.deleteService);
			super.addCommand("update",this.updateService);
		}
}
