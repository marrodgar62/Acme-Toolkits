package acme.features.inventor.announcement;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.announcement.Announcement;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorAnnouncementController extends AbstractController<Inventor, Announcement> {
	// Internal state ---------------------------------------------------------

		@Autowired
		protected InventorAnnouncementListRecentAllService	announcementListAllService;
		
		@Autowired
		protected InventorAnnouncementShowService	showService;

	// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-announcements", "list", this.announcementListAllService);
			super.addCommand("show", this.showService);
		}
}
