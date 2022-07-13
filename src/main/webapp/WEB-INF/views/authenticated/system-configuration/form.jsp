<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-textbox code="authenticated.systemconfiguration.form.label.currency" path="currency"/>
	<acme:input-textbox code="authenticated.systemconfiguration.form.label.currencies" path="currencies"/>	
</acme:form>
<acme:button code="authenticated.systemconfiguration.form.button.exchange" action="/authenticated/money-exchange/perform"/>

