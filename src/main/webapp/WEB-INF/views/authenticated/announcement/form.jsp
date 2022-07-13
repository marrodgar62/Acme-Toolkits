
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-textbox code="authenticated.announcement.form.label.creation" path="creation"/>
	<acme:input-textbox code="authenticated.announcement.form.label.title" path="title"/>
	<acme:input-textbox code="authenticated.announcement.form.label.body" path="body"/>	
	<acme:input-textbox code="authenticated.announcement.form.label.flag" path="flag"/>
	<acme:input-url code="authenticated.announcement.form.label.url" path="url"/>	
		
		
</acme:form>

