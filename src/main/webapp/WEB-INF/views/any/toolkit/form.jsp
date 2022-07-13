
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<acme:input-textbox code="any.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="any.toolkit.form.label.code" path="code"/>	
	<acme:input-textarea code="any.toolkit.form.label.description" path="description"/>	
	<acme:input-textarea code="any.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-url code="any.toolkit.form.label.link" path="link"/>
	<jstl:if test="${price!=null}">
		<acme:input-money code="any.toolkit.form.label.price" path="price"/>
	</jstl:if>
	<jstl:if test="${toolkitId!=null}">
		<acme:button action="/any/artefact/list-artefact-toolkit?masterId=${toolkitId}" code="any.toolkit.form.button.artefact"/>
	</jstl:if>
</acme:form>