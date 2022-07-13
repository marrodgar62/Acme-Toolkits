<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>


<br />
<acme:list>
	<acme:list-column code="inventor.patronage-report.list.label.creation-moment" path="creationMoment" width="20%"/>	
	<acme:list-column code="inventor.patronage-report.list.label.memorandum" path="memorandum" width="20%"/>
	<acme:list-column code="inventor.patronage-report.list.label.link" path="link" width="20%"/>	
		
</acme:list>