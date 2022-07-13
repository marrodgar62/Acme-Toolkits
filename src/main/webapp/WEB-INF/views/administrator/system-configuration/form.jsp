
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	

<jstl:choose>
		<jstl:when test="${command== 'show'}">
		<acme:input-textbox code="administrator.systemConfiguration.label.currency" path="currency"/>
		<acme:input-textbox code="administrator.systemConfiguration.label.currencies" path="currencies"/>
		<acme:input-textbox code="administrator.systemConfiguration.label.weakTerms" path="allWeakTerms"/>	
		<acme:input-textbox code="administrator.systemConfiguration.label.strongTerms" path="allStrongTerms"/>
		<acme:input-textbox code="administrator.systemConfiguration.label.weakThreshold" path="weakThreshold"/>	
		<acme:input-textbox code="administrator.systemConfiguration.label.strongThreshold" path="strongThreshold"/>

		
			<acme:button code="administrator.systemConfiguration.form.button.update" action="/administrator/system-configuration/update"/>
		</jstl:when>
		
		<jstl:when test="${command == 'update'}">
		<acme:input-textbox code="administrator.systemConfiguration.label.currency" path="currency"/>
		<acme:input-textbox code="administrator.systemConfiguration.label.currencies" path="currencies"/>
		<acme:input-textbox code="administrator.systemConfiguration.label.weakTermsSpanish" path="weakTermsSpanish"/>
		<acme:input-textbox code="administrator.systemConfiguration.label.weakTermsEnglish" path="weakTermsEnglish"/>	
		<acme:input-textbox code="administrator.systemConfiguration.label.strongTermsSpanish" path="strongTermsSpanish"/>
		<acme:input-textbox code="administrator.systemConfiguration.label.strongTermsEnglish" path="strongTermsEnglish"/>
		<acme:input-textbox code="administrator.systemConfiguration.label.weakThreshold" path="weakThreshold"/>	
		<acme:input-textbox code="administrator.systemConfiguration.label.strongThreshold" path="strongThreshold"/>

		
		<acme:submit code="administrator.systemConfiguration.form.button.update" action="/administrator/system-configuration/update"/>
		</jstl:when>		
	</jstl:choose>		
	
</acme:form>