
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<jstl:if test="${status == 'ACCEPTED'}">
	<acme:button code="inventor.patronage-reports.form.button.list-mine-reports" action="/inventor/patronage-report/list-mine-reports?id=${id}"/>
	<acme:button code="inventor.patronage-reports.list.button.create.patronage-report" action="/inventor/patronage-report/create?id=${id}"/>
	</jstl:if>
	
	<jstl:if test="${acme:anyOf(command, 'show, update, delete, publish')}">
	<acme:input-textbox readonly="true" code="inventor.patronages.form.label.status" path="status"/>
	</jstl:if>
	
	<acme:input-textbox readonly="true" code="inventor.patronages.form.label.code" path="code" />
	<acme:input-textbox readonly="true" code="inventor.patronages.form.label.legal-stuff" path="legalStuff"/>	
	<acme:input-money readonly="true" code="inventor.patronages.form.label.budget" path="budget"/>
  <acme:input-money readonly="true" code="inventor.patronage.form.label.money-exchange" path="moneyExchange"/>
	<acme:input-moment readonly="true" code="inventor.patronages.form.label.init-period" path="initPeriod"/>
	<acme:input-moment readonly="true" code="inventor.patronages.form.label.final-period" path="finalPeriod"/>	
	<acme:input-url readonly="true" code="inventor.patronages.form.label.link" path="link"/>
	
	<jstl:if test="${command == 'show'}">
		<br></br>
		<acme:message code="inventor.patronages.patron.form.label.title"/>
		<acme:input-textbox readonly="true" code="inventor.patronages.patron.form.label.username" path="patronUsername"/>	
		<acme:input-textbox readonly="true" code="inventor.patronages.patron.form.label.company" path="patronCompany"/>
		<acme:input-textbox readonly="true" code="inventor.patronages.patron.form.label.link" path="patronLink"/>	
		<acme:input-textbox readonly="true" code="inventor.patronages.patron.form.label.statement" path="patronStatement"/>	
	</jstl:if>
	
		
	
	<br></br>
	<jstl:choose>
		<jstl:when test="${status == 'PROPOSED'}">
			<acme:submit code="inventor.patronages.form.button.accept" action="/inventor/patronages/update?new-status=${'ACCEPTED'}"/>
			<acme:submit code="inventor.patronages.form.button.denied" action="/inventor/patronages/update?new-status=${'DENIED'}"/>
		</jstl:when>
	</jstl:choose>
	
</acme:form>