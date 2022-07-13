/*
 * TemporalAwareTestHarness.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.chirp.Chirp;
import acme.framework.helpers.FactoryHelper;
import acme.testing.any.chirps.ChirpRepository;
import acme.testing.authenticated.announcement.AnnouncementRepository;

public class TemporalAwareTestHarness extends TestHarness {

	// Lifecycle management ---------------------------------------------------
	@Autowired
	private AnnouncementRepository Arepository;
	
	@Autowired
	private ChirpRepository repository;
	
	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();
		FactoryHelper.autowire(this);
		this.patchChirps();
		this.patchAnnouncements();
	}
	

	// Business methods -------------------------------------------------------
	
	protected void patchChirps() {
		Collection<Chirp> chirps;
		Date moment;
		
		chirps = this.repository.chirpsToPatch();
		for(final Chirp chirp : chirps) {
			moment = this.adjustMoment(chirp.getCreationMoment());
			chirp.setCreationMoment(moment);
			this.repository.save(chirp);
		}
	}
	
	protected void patchAnnouncements() {
		Collection<acme.entities.announcement.Announcement> announcements;
		Date moment;

		announcements = this.Arepository.announcementToPatch();
		for (final acme.entities.announcement.Announcement announcement : announcements) {
			moment = this.adjustMoment(announcement.getCreation());
			announcement.setCreation(moment);
			this.Arepository.save(announcement);
		}
	}

	protected String computeDeltaMoment(final int deltaDays) {
		assert deltaDays <= 0;

		String result;
		Calendar calendar;
		SimpleDateFormat formatter;

		calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		calendar.set(Calendar.MILLISECOND, 000);
		calendar.add(Calendar.DAY_OF_MONTH, deltaDays);
		formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		result = formatter.format(calendar.getTime());

		return result;
	}

	protected Date adjustMoment(final Date currentMoment) {
		assert currentMoment != null;

		Date result;
		Calendar calendar;
		int day;

		calendar = Calendar.getInstance();

		calendar.setTime(currentMoment);
		day = calendar.get(Calendar.DAY_OF_MONTH);

		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		calendar.set(Calendar.MILLISECOND, 000);
		calendar.add(Calendar.DAY_OF_MONTH, -day);

		result = calendar.getTime();

		return result;

	}

	// Ancillary methods ------------------------------------------------------

}
