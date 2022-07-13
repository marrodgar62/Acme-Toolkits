<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="patron.patronages.list.label.code" path="code" width="20%" />
	<acme:list-column code="patron.patronages.list.label.status" path="status" width="20%" />
	<acme:list-column code="patron.patronages.list.label.legalStuff" path="legalStuff" width="20%" />
	<acme:list-column code="patron.patronages.list.label.budget" path="budget" width="20%" />
	<acme:list-column code="patron.patronages.list.label.published" path="published" width="20%" />
	<acme:list-column code="patron.patronages.list.label.username" path="inventor.username" width="20%" />
</acme:list>

<acme:button code="patron.patronages.list.button.create" action="/patron/patronages/create"/>