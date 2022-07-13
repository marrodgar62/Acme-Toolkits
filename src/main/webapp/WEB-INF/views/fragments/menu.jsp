<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.chirps.list" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.anonymous.artefacts.list" action="/any/artefact/list?artefactType=0"/>
			<acme:menu-suboption code="master.menu.user-account.toolkits.list" action="/any/toolkit/list-all"/>
			<acme:menu-suboption code="master.menu.any.user-accounts" action="/any/user-account/list-enabled-user-accounts"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-marpercor8" action="https://github.com/marpercor8"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-ramoonrb" action="https://github.com/ramoonrb"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-marrodgar62" action="https://github.com/marrodgar62"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-cargarrod12" action="https://github.com/cargarrod12"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-alvuberui" action="https://github.com/alvuberui"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link.juagomram4" action="https://github.com/juagomram4"/>
		</acme:menu-option>



		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.artefacts.list" action="/any/artefact/list?artefactType=0"/>
			<acme:menu-suboption code="master.menu.user-account.toolkits.list" action="/any/toolkit/list-all"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.chirps.list" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.user-account.announcements.list" action="/authenticated/announcement/list-all-announcements"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.user-accounts" action="/any/user-account/list-enabled-user-accounts"/>
			<acme:menu-suboption code="master.menu.authenticated.system-configuration" action="/authenticated/system-configuration/show"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.administrator-dashboard" action="/administrator/administrator-dashboard/show"/>
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-suboption code="master.menu.administrator.system-configuration" action="/administrator/system-configuration/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.create-announcement" action="/administrator/announcement/create"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
		</acme:menu-option>
		
		
		<acme:menu-option code="master.menu.inventor" access="hasRole('Inventor')">
			<acme:menu-suboption code="master.menu.inventor.artefact.list" action="/inventor/artefact/list-mine"/>
			<acme:menu-suboption code="master.menu.inventor.patronages.list" action="/inventor/patronages/list-mine"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.inventor.my-toolkits" action="/inventor/toolkit/list-mine"/>		
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.patronages.list" action="/patron/patronages/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.patron.dashboard" action="/patron/patron-dashboard/show"/>			
		</acme:menu-option>
		
		

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-inventor" action="/authenticated/inventor/create" access="!hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.inventor" action="/authenticated/inventor/update" access="hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.become-patron" action="/authenticated/patron/create" access="!hasRole('Patron')"/>
			<acme:menu-suboption code="master.menu.user-account.patron" action="/authenticated/patron/update" access="hasRole('Patron')"/>
			</acme:menu-option>
		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

