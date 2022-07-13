<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<acme:form>
	<acme:message code="administrator.administrator-dashboard.form.label.componentsTitle"/>
	<jstl:if test="${empty avgRetailPriceOfComponents}">
	<br>
	<acme:message code="administrator.administrator-dashboard.form.label.nohayComponentes"/>
		<br>
		<br>
	
	</jstl:if>	
	<br>	
	
	<acme:message code="administrator.administrator-dashboard.form.label.absoluteTitle"/>		
	<table class="table table-sm">
		<caption></caption>
		<caption></caption>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.NumberOfProposedPatronages"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${NumberOfProposedPatronages}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.NumberOfAcceptedPatronages"/>
				</th>
				<td style= "text-align:right;">
					<acme:print value="${NumberOfAcceptedPatronages}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.NumberOfDeniedPatronages"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${NumberOfDeniedPatronages}"/> 
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.NumberOfComponents"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${NumberOfComponents}"/> 
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.NumberOfTools"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${NumberOfTools}"/> 
				</td>		
			</tr>
	</table>
	
	
	
	
	<acme:message code="administrator.administrator-dashboard.form.label.deviationTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
	<caption></caption>
		<jstl:forEach items="${deviationRetailPriceOfComponents}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.deviation-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.and-technology"/>
			<acme:print value="${string2[1]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.avg-title"/>	
	<table class="table table-sm">
		<caption></caption>
		<caption></caption>
		<jstl:forEach items="${avgRetailPriceOfComponents}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.avg-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.and-technology"/>
			<acme:print value="${string2[1]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">				
			<acme:print value="${entry.value}"/>				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	
	<acme:message code="administrator.administrator-dashboard.form.label.maxTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${maxRetailPriceOfComponents}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.max-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.and-technology"/>
			<acme:print value="${string2[1]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.minTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${minRetailPriceOfComponents}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.min-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.and-technology"/>
			<acme:print value="${string2[1]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.toolsTitle"/>
	<jstl:if test="${empty avgRetailPriceOfTools}">
		<br></br>
		<acme:message code="administrator.administrator-dashboard.form.label.nohayHerramientas"/>
		<br></br>
	</jstl:if>		
		<br></br>	
	
	<acme:message code="administrator.administrator-dashboard.form.label.deviationTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${deviationRetailPriceOfTools}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.deviation-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.avg-title"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${avgRetailPriceOfTools}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.avg-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	
	
	<acme:message code="administrator.administrator-dashboard.form.label.minTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		<caption></caption>
		<jstl:forEach items="${minRetailPriceOfTools}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.min-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	<acme:message code="administrator.administrator-dashboard.form.label.maxTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${maxRetailPriceOfTools}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.max-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.patronageTitle"/>
	<jstl:if test="${empty avgBudgetByStatus}">
		<br></br>
	<acme:message code="administrator.administrator-dashboard.form.label.nohayPatrocinios"/>
		<br></br>
	</jstl:if>		
	
	
	<acme:message code="administrator.administrator-dashboard.form.label.deviationTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${deviationBudgetByStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.patronage-deviation-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.avg-title"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${avgBudgetByStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.patronage-avg-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	
	
	<acme:message code="administrator.administrator-dashboard.form.label.maxTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${maxBudgetByStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.patronage-max-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>	
	
	<acme:message code="administrator.administrator-dashboard.form.label.minTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
	<caption></caption>
		<jstl:forEach items="${minBudgetByStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.patronage-min-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
		
</acme:form>
