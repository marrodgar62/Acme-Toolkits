
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<h2>
<acme:message code="patron.dashboard.form.title.general"/>
</h2>

<table class="table table-sm" aria-describedby="numberPatronages">
	<acme:message code="patron.dashboard.form.label.number-patronages"/>	
	<jstl:forEach items="${numberOfPatronageByStatus}" var="patronages">
		<tr>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key}"/>
			</th>
			<td>
				<acme:print value="${patronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<table class="table table-sm" aria-describedby="averageBudgetPatronages">
	<acme:message code="patron.dashboard.form.label.average-budget-patronages"/>	
	<jstl:forEach items="${averageBudgetOfPatronageByCurrencyAndStatus}" var="patronages">
		<tr>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key.getFirst()}"/>
			</th>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key.getSecond()}"/>
			</th>
			<td>
				<acme:print value="${patronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<table class="table table-sm"  aria-describedby="deviationBudgetPatronages">
	<acme:message code="patron.dashboard.form.label.deviation-budget-patronages"/>	
	<jstl:forEach items="${deviationBudgetOfPatronageByCurrencyAndStatus}" var="patronages">
		<tr>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key.getFirst()}"/>
			</th>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key.getSecond()}"/>
			</th>
			<td>
				<acme:print value="${patronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<table class="table table-sm" aria-describedby="minimumBudgetPatronages"> 
	<acme:message code="patron.dashboard.form.label.minimum-budget-patronages"/>	
	<jstl:forEach items="${minimumBudgetOfPatronageByCurrencyAndStatus}" var="patronages">
		<tr>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key.getFirst()}"/>
			</th>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key.getSecond()}"/>
			</th>
			<td>
				<acme:print value="${patronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<table class="table table-sm" aria-describedby="maximumBudgetPatronages">
	<acme:message code="patron.dashboard.form.label.maximum-budget-patronages"/>	
	<jstl:forEach items="${maximumBudgetOfPatronageByCurrencyAndStatus}" var="patronages">
		<tr>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key.getFirst()}"/>
			</th>
			<th scope="row" style="width:10%">
				<acme:print value="${patronages.key.getSecond()}"/>
			</th>
			<td>
				<acme:print value="${patronages.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>


