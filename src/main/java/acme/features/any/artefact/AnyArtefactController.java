package acme.features.any.artefact;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.artefact.Artefact;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyArtefactController extends AbstractController<Any, Artefact> {
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyArtefactListService	artefactListService;
		

		@Autowired 
		protected AnyArtefactListByToolkitService anyArtefactListByToolkitService;
		
		
		@Autowired
		protected AnyArtefactShowService	showService;
		
		
	// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list","list", this.artefactListService);		
			super.addCommand("list-artefact-toolkit","list", this.anyArtefactListByToolkitService);
			super.addCommand("show", this.showService);
		}
		
}