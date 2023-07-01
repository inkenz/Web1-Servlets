<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    	<fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
        	<title><fmt:message key="cadastro_hotel"/></title>
    	</fmt:bundle>
    </head>
    <body>
        <fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
            <form action="CadastrarHotel" method="POST">
                <fieldset >
                    <legend><fmt:message key="login"/></legend>
                    <fmt:message key="email"/><input type="text" name="email" /><br/>
                    <fmt:message key="password"/><input type="password" name="senha" /><br/>
                    <fmt:message key="CNPJ"/><input type="text" name="cnpj" /><br/>
                    <fmt:message key="name_hotel"/><input type="text" name="nome" /><br/>
                    <fmt:message key="city"/><input type="text" name="cidade" /><br/>
                    <input type="submit" value="<fmt:message key="submit_cadastro"/>" />
                </fieldset>
            </form>
        </fmt:bundle>
 		
    
    </body>
</html>