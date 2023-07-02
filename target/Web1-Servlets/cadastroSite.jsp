<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    	<fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
        	<title><fmt:message key="cadastro_site"/></title>
        </fmt:bundle>
    </head>
    <body>
    	<%
    		if(session.getAttribute("admin")==null){
    			response.sendRedirect("login.jsp");
    		}
    	%>
        <fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
            <form action="CadastroSite" method="POST" accept-charset="UTF-8">
                <fieldset >
                    <legend><fmt:message key="cadastro_site"/></legend>
                    <fmt:message key="email"/><input type="text" name="usuario" /><br/>
                    <fmt:message key="password"/><input type="password" name="senha" /><br/>
                    <fmt:message key="URL"/><input type="text" name="url" /><br/>
                    <fmt:message key="name_site"/><input type="text" name="nome" /><br/>
                    <fmt:message key="telefone"/><input type="text" name="telefone" /><br/>
                    <input type="submit" value="<fmt:message key="submit_cadastro"/>" />
                </fieldset>
            </form>
        </fmt:bundle>


    </body>
</html>
