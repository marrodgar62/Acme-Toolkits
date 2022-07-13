
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	
	<jstl:if test="${command == 'show'}">
		<acme:input-moment code="inventor.patronage-report.form.label.creation-moment" path="creationMoment" readonly="${true}"/>
		<acme:input-textbox code="inventor.patronage-report.form.label.memorandum" path="memorandum" readonly="${true}"/>
		<acme:input-textbox code="inventor.patronage-report.form.label.link" path="link" readonly="${true}"/>
	</jstl:if>
		
	<jstl:if test="${command == 'create'}">
		<acme:input-moment code="inventor.patronage-report.form.label.creation-moment" path="creationMoment" readonly="${true}"/>
		<acme:input-textbox code="inventor.patronage-report.form.label.memorandum" path="memorandum"/>
		<acme:input-textbox code="inventor.patronage-report.form.label.link" path="link"/>
	</jstl:if>
	
	
	
	<jstl:if test="${command == 'create'}">
	
		<acme:input-checkbox code="inventor.patronage-report.form.button.confirmation" path="confirmation"/>
	
	
		<acme:submit code="inventor.patronage-report.form.button.create" action="/inventor/patronage-report/create?id=${patronageId}"/>
	</jstl:if>
	
	
</acme:form>