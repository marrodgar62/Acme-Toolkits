package acme.testing.authenticated.announcement;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.announcement.Announcement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnnouncementRepository extends AbstractRepository{

	@Query("select a from Announcement a where a.creation between '1900/01/01' and '1900/01/31'")
	Collection<Announcement> announcementToPatch();

}
