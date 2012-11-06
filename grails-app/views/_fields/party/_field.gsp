<%@ page import="org.ihc.esa.Party"%>
<%@ page defaultCodec="html" %>
<div class="control-group ${invalid ? 'error' : ''}">
    <label class="control-label" for="${property}">${label}</label>
    <div class="controls">
        <g:select name="${property }" from="${Party.list(sort: 'name') }" optionKey="id" optionValue="name" noSelection="['':'-None Selected-']" />
        <g:if test="${invalid}"><span class="help-inline">${errors.join('<br>')}</span></g:if>
    </div>
</div>