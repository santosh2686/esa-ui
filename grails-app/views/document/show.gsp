
<%@ page import="org.ihc.esa.Document" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'document.label', default: 'Document')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row-fluid">
			
			<div class="span2">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">${entityName}</li>
						<li>
							<g:link action="list">
								<i class="icon-list"></i>
								<g:message code="default.list.label" args="[entityName]" />
							</g:link>
						</li>
						<li>
							<g:link action="create">
								<i class="icon-plus"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="span9">

				<div class="page-header">
					<h1><g:message code="default.show.label" args="[entityName]" /></h1>
				</div>

				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

				<dl>
				
					<g:if test="${documentInstance?.form}">
						<dt><g:message code="document.form.label" default="Form" /></dt>
						
							<dd><g:link controller="form" action="show" id="${documentInstance?.form?.id}">${documentInstance?.form?.encodeAsHTML()}</g:link></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.sirpId}">
						<dt><g:message code="document.sirpId.label" default="Sirp Id" /></dt>
						
							<dd><g:fieldValue bean="${documentInstance}" field="sirpId"/></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.requestor}">
						<dt><g:message code="document.requestor.label" default="Requestor" /></dt>
						
							<dd><g:fieldValue bean="${documentInstance}" field="requestor"/></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.requestorEmail}">
						<dt><g:message code="document.requestorEmail.label" default="Requestor Email" /></dt>
						
							<dd><g:fieldValue bean="${documentInstance}" field="requestorEmail"/></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.owner}">
						<dt><g:message code="document.owner.label" default="Owner" /></dt>
						
							<dd><g:fieldValue bean="${documentInstance}" field="owner"/></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.ownerEmail}">
						<dt><g:message code="document.ownerEmail.label" default="Owner Email" /></dt>
						
							<dd><g:fieldValue bean="${documentInstance}" field="ownerEmail"/></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.justification}">
						<dt><g:message code="document.justification.label" default="Justification" /></dt>
						
							<dd><g:fieldValue bean="${documentInstance}" field="justification"/></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.vendorRepresentativeParty}">
						<dt><g:message code="document.vendorRepresentativeParty.label" default="Vendor Representative Party" /></dt>
						
							<dd><g:link controller="party" action="show" id="${documentInstance?.vendorRepresentativeParty?.id}">${documentInstance?.vendorRepresentativeParty?.encodeAsHTML()}</g:link></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.createdBy}">
						<dt><g:message code="document.createdBy.label" default="Created By" /></dt>
						
							<dd><g:fieldValue bean="${documentInstance}" field="createdBy"/></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.updatedBy}">
						<dt><g:message code="document.updatedBy.label" default="Updated By" /></dt>
						
							<dd><g:fieldValue bean="${documentInstance}" field="updatedBy"/></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.dateCreated}">
						<dt><g:message code="document.dateCreated.label" default="Date Created" /></dt>
						
							<dd><g:formatDate date="${documentInstance?.dateCreated}" /></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.items}">
						<dt><g:message code="document.items.label" default="Items" /></dt>
						
							<g:each in="${documentInstance.items}" var="i">
							<dd><g:link controller="item" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></dd>
							</g:each>
						
					</g:if>
				
					<g:if test="${documentInstance?.lastUpdated}">
						<dt><g:message code="document.lastUpdated.label" default="Last Updated" /></dt>
						
							<dd><g:formatDate date="${documentInstance?.lastUpdated}" /></dd>
						
					</g:if>
				
					<g:if test="${documentInstance?.responses}">
						<dt><g:message code="document.responses.label" default="Responses" /></dt>
						
							<g:each in="${documentInstance.responses}" var="r">
							<dd><g:link controller="questionResponse" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></dd>
							</g:each>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${documentInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${documentInstance?.id}">
							<i class="icon-pencil"></i>
							<g:message code="default.button.edit.label" default="Edit" />
						</g:link>
						<button class="btn btn-danger" type="submit" name="_action_delete">
							<i class="icon-trash icon-white"></i>
							<g:message code="default.button.delete.label" default="Delete" />
						</button>
					</div>
				</g:form>

			</div>

		</div>
	</body>
</html>
