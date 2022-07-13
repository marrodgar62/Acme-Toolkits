
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>




	<jstl:if test="${command == 'show'}">
			<jstl:if test="${status == 'ACCEPTED'}">
			<acme:button code="patron.patronage-reports.form.button.list-reports" action="/patron/patronage-report/list?id=${id}"/>
			</jstl:if>
	</jstl:if>

<br />
<br />
<acme:form>
	<acme:input-textbox code="patron.patronage.form.label.status" path="status" readonly="${true}"/>

		<jstl:if test="${acme:anyOf(command, 'show, delete, publish')}">
			<acme:input-textbox code="patron.patronage.form.label.code" path="code" readonly="${true}" />
			<acme:input-moment readonly="${true}" code="patron.patronage.form.label.initPeriod" path="initPeriod"/>
			<acme:input-moment readonly="${true}" code="patron.patronage.form.label.finalPeriod" path="finalPeriod"/>
			<acme:input-money readonly="${true}" code="patron.patronage.form.label.budget" path="budget"/>
			
			<acme:input-money  readonly="${true}" code="patron.patronage.form.label.money-exchange" path="moneyExchange"/>
				
			<acme:input-textbox readonly="${true}" code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
			<acme:input-textbox readonly="${true}" code="patron.patronage.form.label.link" path="link"/>
		</jstl:if>	
		<jstl:if test="${command == 'show'}">
			<br></br>
			<acme:message code="patron.patronages.inventor.form.label.title"/>
			<acme:input-textbox readonly="true" code="patron.patronages.inventor.form.label.username" path="inventorUsername"/>		
			<acme:input-textbox readonly="true" code="patron.patronages.inventor.form.label.company" path="inventorCompany"/>
			<acme:input-textbox readonly="true" code="patron.patronages.inventor.form.label.link" path="inventorLink"/>	
			<acme:input-textbox readonly="true" code="patron.patronages.inventor.form.label.statement" path="inventorStatement"/>		
		</jstl:if>
	
	
	<jstl:if test="${acme:anyOf(command, 'create, update') }">
		<acme:input-textbox code="patron.patronage.form.label.code" path="code" />
		<acme:input-moment code="patron.patronage.form.label.initPeriod" path="initPeriod"/>
		<acme:input-moment code="patron.patronage.form.label.finalPeriod" path="finalPeriod"/>
		<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
		<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
		<acme:input-textbox code="patron.patronage.form.label.link" path="link"/>
	</jstl:if>
	


	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show') && !published}">
			<acme:button code="patron.patronage.form.button.update" action="/patron/patronages/update?id=${id}"/>
			<acme:submit code="patron.patronage.form.button.delete" action="/patron/patronages/delete"/>
			<acme:submit code="patron.patronage.form.button.publish" action="/patron/patronages/publish"/>
		</jstl:when>
	</jstl:choose>
	
	<jstl:if test="${acme:anyOf(command, 'create, update') }">
	<acme:input-select  code="patron.patronage.form.label.data" path="inventor">
				<jstl:forEach items="${inventors}" var="inventor">
					<acme:input-option code="${inventor.getUserAccount().getUsername()}: ${inventor.getCompany()}" value="${inventor.getId()}"/>
				</jstl:forEach>
			</acme:input-select>
	</jstl:if>
	
	<jstl:if test="${command == 'create'}">
			<acme:submit code="patron.patronage.form.button.create" action="/patron/patronages/create"/>
	</jstl:if>
	
	<jstl:if test="${command == 'update'}">
		<acme:submit code="patron.patronage.form.button.update" action="/patron/patronages/update"/>
	</jstl:if>
</acme:form>