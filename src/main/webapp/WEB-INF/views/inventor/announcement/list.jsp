<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.announcement.list.label.creation" path="creation" width="20%"/>	
	<acme:list-column code="inventor.announcement.list.label.title" path="title" width="20%"/>
	<acme:list-column code="inventor.announcement.list.label.body" path="body" width="20%"/>	
	<acme:list-column code="inventor.announcement.list.label.flag" path="flag" width="20%"/>
	<acme:list-column code="inventor.announcement.list.label.url" path="url" width="20%"/>	
	
</acme:list>