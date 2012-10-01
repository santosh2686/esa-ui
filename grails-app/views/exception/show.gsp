
<%@ page import="org.ihc.esa.Document"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="bootstrap">
<g:set var="entityName" value="${message(code: 'exception.label', default: 'Exception')}" />
<title>
	${exceptionInstance.id }
</title>
</head>
<body>
	<div class="row-fluid">

		<div class="span2">
			<div class="well">
				<ul class="nav nav-list">
					<li class="nav-header">
						${entityName}
					</li>
					<li><g:link action="list">
							<i class="icon-list"></i>
							<g:message code="default.list.label" args="[entityName]" />
						</g:link></li>
					<li><g:link action="create">
							<i class="icon-plus"></i>
							<g:message code="default.create.label" args="[entityName]" />
						</g:link></li>
				</ul>
			</div>
		</div>

		<div class="span9">

			<div class="page-header">
				<h1>
					${exceptionInstance.title }
				</h1>
			</div>

			<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">
					${flash.message}
				</bootstrap:alert>
			</g:if>

			<dl>

				<g:if test="${exceptionInstance?.form}">
					<dt>
						<g:message code="exception.form.label" default="Form Type" />
					</dt>

					<dd>
						<g:fieldValue bean="${exceptionInstance}" field="form" />
					</dd>

				</g:if>
				
				<g:if test="${exceptionInstance?.form}">
                    <dt>
                        <g:message code="exception.title.label" default="Title" />
                    </dt>

                    <dd>
                        <g:fieldValue bean="${exceptionInstance}" field="title" />
                    </dd>

                </g:if>

				<g:if test="${exceptionInstance?.createdBy}">
					<dt>
						<g:message code="exception.createdBy.label" default="Created By" />
					</dt>

					<dd>
						<g:fieldValue bean="${exceptionInstance}" field="createdBy" />
					</dd>

				</g:if>

				<g:if test="${exceptionInstance?.updatedBy}">
					<dt>
						<g:message code="exception.updatedBy.label" default="Updated By" />
					</dt>

					<dd>
						<g:fieldValue bean="${exceptionInstance}" field="updatedBy" />
					</dd>

				</g:if>

				<g:if test="${exceptionInstance?.dateCreated}">
					<dt>
						<g:message code="exception.dateCreated.label" default="Date Created" />
					</dt>

					<dd>
						<g:formatDate date="${exceptionInstance?.dateCreated}" />
					</dd>

				</g:if>

				<g:if test="${exceptionInstance?.lastUpdated}">
					<dt>
						<g:message code="exception.lastUpdated.label" default="Last Updated" />
					</dt>

					<dd>
						<g:formatDate date="${exceptionInstance?.lastUpdated}" />
					</dd>

				</g:if>

			</dl>

			<g:form>
				<g:hiddenField name="id" value="${exceptionInstance?.id}" />
				<div class="form-actions">
					<g:link class="btn" action="edit" id="${exceptionInstance?.id}">
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